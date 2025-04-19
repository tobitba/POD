package ar.edu.itba.pod.server.ticket;


import ar.edu.itba.pod.grpc.trainTickets.Destinations;
import ar.edu.itba.pod.grpc.trainTickets.Ticket;
import ar.edu.itba.pod.grpc.trainTickets.Train;
import ar.edu.itba.pod.grpc.trainTickets.TrainTicketServiceGrpc;
import ar.edu.itba.pod.server.ticket.repository.TicketRepository;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;
import ar.edu.itba.pod.grpc.trainTickets.Reservation;

import java.util.ArrayList;
import java.util.List;

public class TrainTicketServant extends TrainTicketServiceGrpc.TrainTicketServiceImplBase {
    TicketRepository ticketRepository = new TicketRepository();
    @Override
    public void getDestinations(Empty request, StreamObserver<Destinations> responseObserver) {
       responseObserver.onNext(Destinations.newBuilder().addAllDestinations(ticketRepository.getDestinations()).build());
       responseObserver.onCompleted();
    }

    @Override
    public void getTrainsForDestination(StringValue request, StreamObserver<Train> responseObserver) {
        ticketRepository.getAvailability(request.getValue()).forEach(train ->
                responseObserver.onNext(Train.newBuilder()
                        .setId(train.id())
                        .setDestination(train.destination())
                        .setTime(train.time())
                        .setAvailableCount(train.availableSeats()).build()));
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Ticket> purchaseTicket(StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Reservation> responseObserver) {
        return new StreamObserver<>() {
            final List<Ticket> tickets = new ArrayList<>();
            @Override
            public void onNext(Ticket ticket) {
                //Lo que hago con cada mensaje del Cliente (.onNext del Client)
                tickets.add(ticket);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                //Lo que hago cuando el Cliente termina (.onCompleted del cliente)
                String reservationId = ticketRepository.addReservation(tickets);
                responseObserver.onNext(Reservation.newBuilder().setId(reservationId).setTicketCount(tickets.size()).build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<Reservation> getTicketsForReservations(StreamObserver<Ticket> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(Reservation reservation) {
                //Lo que hago cuando el Cliente me manda una Reservation
                List<Ticket> tickets =  ticketRepository.getReservation(reservation.getId()).orElse(List.of()); //TODO: esta ok
                tickets.forEach(ticket -> responseObserver.onNext(Ticket.newBuilder()
                        .setId(ticket.getId())
                        .setTrainId(ticket.getTrainId()) //siempre va a ser vacio xd
                        .setPassengerName(ticket.getPassengerName()).build()));
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
