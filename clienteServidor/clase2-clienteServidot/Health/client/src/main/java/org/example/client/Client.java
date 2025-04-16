package org.example.client;

import ar.edu.itba.pod.grpc.health.HealthServiceGrpc;
import ar.edu.itba.pod.grpc.user.AccountStatus;
import ar.edu.itba.pod.grpc.user.LoginInformation;
import ar.edu.itba.pod.grpc.user.User;
import ar.edu.itba.pod.grpc.user.UserServiceGrpc;
import com.google.protobuf.BoolValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ar.edu.itba.pod.grpc.health.PingResponse;

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
           /* HealthServiceGrpc.HealthServiceBlockingStub stub = HealthServiceGrpc.newBlockingStub(channel);
             PingResponse response =  stub.ping(ar.edu.itba.pod.grpc.health.PingRequest.newBuilder().build());
            System.out.println(response);*/
            UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
            BoolValue boll =  stub.register(ar.edu.itba.pod.grpc.user.User.newBuilder().setId(1)
                    .setUserName("Juan").setDisplayName("Juan P.")
                    .setStatus(AccountStatus.ACCOUNT_STATUS_ACTIVE)
                    .build());
            System.out.println("response = " + boll);
            User juan = stub.doLogin(LoginInformation.newBuilder().setUserName("Juan").build());
            System.out.println("Juan info is :" + juan);
            System.out.println(stub.getRoles(ar.edu.itba.pod.grpc.user.User.newBuilder().build()));
        } finally {
            channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
