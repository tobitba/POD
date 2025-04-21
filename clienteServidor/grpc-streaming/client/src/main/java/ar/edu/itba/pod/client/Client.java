package ar.edu.itba.pod.client;

import ar.edu.itba.pod.grpc.trainTickets.TrainTicketServiceGrpc;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ar.edu.itba.pod.grpc.trainTickets.Destinations;
import ar.edu.itba.pod.grpc.trainTickets.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import ar.edu.itba.pod.grpc.trainTickets.Reservation;
import ar.edu.itba.pod.grpc.trainTickets.Ticket;

public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("grpc-streaming Client Starting ...");
        logger.info("grpc-com-patterns Client Starting ...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext().intercept(new TicketClientLoggerInterceptor())
                .build();

        try {
            TrainTicketServiceGrpc.TrainTicketServiceBlockingStub blockingStub = TrainTicketServiceGrpc.newBlockingStub(channel);
            Destinations dest = blockingStub.getDestinations(Empty.getDefaultInstance());
            System.out.println("Available Destinations:");
            for (int i = 0; i < dest.getDestinationsCount(); i++) {
                System.out.println(dest.getDestinations(i));
            }
            System.out.println("Trains for Mar del Plata with blocking stub");
            Iterator<Train> trainsForDestination = blockingStub.getTrainsForDestination(StringValue.of("Cordoba"));
            while (trainsForDestination.hasNext()) {
                System.out.println(trainsForDestination.next());
            }
            System.out.println("Trains for Mar del Plata with async stub");
            TrainTicketServiceGrpc.TrainTicketServiceStub asyncStub = TrainTicketServiceGrpc.newStub(channel);
            CompletableFuture<String> cf = new CompletableFuture<>();
            asyncStub.getTrainsForDestination(StringValue.of("Cordoba"), new StreamObserver<Train>() {
                @Override
                public void onNext(Train train) {
                    System.out.println("async" + train);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.err.println("error on async");
                }

                @Override
                public void onCompleted() {
                    cf.complete("yey");
                }
            });
            try {
                System.out.println(cf.get());
            } catch (Exception ignored) {
            }

            CompletableFuture<Reservation> cfReservation = new CompletableFuture<>();
            StreamObserver<Reservation> response = new StreamObserver<Reservation>() {
                @Override
                public void onNext(Reservation reservation) {
                    cfReservation.complete(reservation);
                }

                @Override
                public void onError(Throwable throwable) {

                }

                @Override
                public void onCompleted() {

                }
            };
            StreamObserver<Ticket> ticketStreamObserver = asyncStub.purchaseTicket(response);
            Arrays.asList("John", "Paul", "Ringo").forEach(name -> {
                ticketStreamObserver.onNext(Ticket.newBuilder().setPassengerName(name).build());
            });
            ticketStreamObserver.onCompleted();
            Reservation reservation = null;
            try {
                System.out.println("Reservation:");
                reservation = cfReservation.get();
                System.out.println(reservation);
            } catch (Exception ignored){}


            List<Ticket> tickets = new ArrayList<>();
            CountDownLatch finishLatch = new CountDownLatch(1);
            StreamObserver<Ticket> observer = new StreamObserver<>() {
                @Override
                public void onNext(Ticket ticket) {
                    tickets.add(ticket);
                }
                @Override
                public void onError(Throwable throwable) {}
                @Override
                public void onCompleted() {
                    finishLatch.countDown();
                }
            };
            StreamObserver<Reservation> reservationStreamObserver = asyncStub.getTicketsForReservations(observer);
            reservationStreamObserver.onNext(reservation);
            reservationStreamObserver.onCompleted();
            finishLatch.await();
            System.out.println("TICKETS");
            tickets.forEach(System.out::println);

        } finally {
            channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
