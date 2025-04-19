package ar.edu.itba.pod.grpc.server;

import ar.edu.itba.pod.grpc.ServiceGrpc;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class ServiceServant extends ServiceGrpc.ServiceImplBase {

    private final List<String> fortunes;
    private final Random random = new Random();

    public ServiceServant(List<String> fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public void ping(Empty request, StreamObserver<StringValue> responseObserver) {
        responseObserver.onNext(StringValue.of("pong"));
        responseObserver.onCompleted();
    }

    @Override
    public void time(Empty request, StreamObserver<StringValue> responseObserver) {
        responseObserver.onNext(StringValue.of(String.valueOf(LocalDateTime.now())).build());
//En las respuestas ponen que retorna un entero asi:
//responseObserver.onNext(UInt32Value.of(LocalDateTime.now().getHour()));
        responseObserver.onCompleted();
    }

    @Override
    public void echo(StringValue request, StreamObserver<StringValue> responseObserver) {
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

    @Override
    public void hello(StringValue request, StreamObserver<StringValue> responseObserver) {
        responseObserver.onNext(StringValue.of("Hello " + request.getValue())); //TODO: preguntar tema formatted de la respuesta
        responseObserver.onCompleted();
    }

    @Override
    public void fortune(Empty request, StreamObserver<StringValue> responseObserver) {
        responseObserver.onNext(StringValue.of(fortunes.get(random.nextInt(0,fortunes.size())))); //TODO: preguntar por la clase SecureRandom de la respuesta y ver tema sincronizacion de los servants
        responseObserver.onCompleted();
    }
}
