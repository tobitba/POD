package org.example.client;

import ar.edu.itba.pod.grpc.health.HealthServiceGrpc;
import ar.edu.itba.pod.grpc.user.*;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.BoolValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ar.edu.itba.pod.grpc.health.PingResponse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("Health Client Starting ...");
        logger.info("grpc-com-patterns Client Starting ...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        try {
            //Health Service
          /* HealthServiceGrpc.HealthServiceBlockingStub hstub = HealthServiceGrpc.newBlockingStub(channel);
             PingResponse response =  hstub.ping(ar.edu.itba.pod.grpc.health.PingRequest.newBuilder().build());
            System.out.println(response);*/

            //UserService Blocking Stub
            /*UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
            BoolValue boll =  stub.register(ar.edu.itba.pod.grpc.user.User.newBuilder().setId(1)
                    .setUserName("Juan").setDisplayName("Juan P.")
                    .setStatus(AccountStatus.ACCOUNT_STATUS_ACTIVE)
                    .build());
            System.out.println("response = " + boll);
            User juan = stub.doLogin(LoginInformation.newBuilder().setUserName("Juan").build());
            System.out.println("Juan info is :" + juan);
            System.out.println(stub.getRoles(ar.edu.itba.pod.grpc.user.User.newBuilder().build()));*/

            //UserService Future Stub
          /*  ExecutorService executorService = Executors.newFixedThreadPool(10);
            UserServiceGrpc.UserServiceFutureStub futureStub = UserServiceGrpc.newFutureStub(channel);
            ListenableFuture<UserRoles> future =  futureStub.getRoles(User.newBuilder().build());
            Futures.addCallback(future, new FutureCallback<UserRoles>() {
                @Override
                public void onSuccess(UserRoles userRoles) {
                    System.out.println(userRoles.getRolesBySiteMap());
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.err.println("Error: " + throwable.getMessage());
                }
            }, executorService);
            executorService.awaitTermination(100, TimeUnit.SECONDS);//TODO: esta ok esto?*/

            //UserService Async Stub
            UserServiceGrpc.UserServiceStub asyncStub = UserServiceGrpc.newStub(channel);
            asyncStub.getRoles(User.newBuilder().build(),new StreamObserver<UserRoles>() {
                @Override
                public void onNext(UserRoles value) {
                    System.out.println(value.getRolesBySiteMap());  //TODO: noo imprime nada :(
                }
                @Override
                public void onError(Throwable t) {
                    System.err.println("Error: " + t.getMessage());
                }
                @Override
                public void onCompleted() {
                    System.out.println("Completed");
                }
            });
        } finally {
            channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
