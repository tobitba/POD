package org.example.server;

import ar.edu.itba.pod.grpc.health.PingRequest;
import ar.edu.itba.pod.grpc.health.PingResponse;
import io.grpc.stub.StreamObserver;

public class HealthServant extends ar.edu.itba.pod.grpc.health.HealthServiceGrpc.HealthServiceImplBase {

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(PingResponse.newBuilder().setMessage("Hello").build());
        responseObserver.onCompleted();
    }
}
