package ar.edu.itba.pod.grpc.client;

import ar.edu.itba.pod.grpc.ServiceGrpc;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("tp-grpc-com-patterns Client Starting ...");
        logger.info("grpc-com-patterns Client Starting ...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        try {
            ServiceGrpc.ServiceBlockingStub stub = ServiceGrpc.newBlockingStub(channel);
            System.out.println(stub.ping(Empty.getDefaultInstance())); //TODO: esta ok esto?
            System.out.println(stub.echo(StringValue.of("buenas y santas, todo piola?")));
            System.out.println(stub.time(Empty.getDefaultInstance()));
            System.out.println(stub.hello(StringValue.of("Tobi")));
            System.out.println(stub.fortune(Empty.getDefaultInstance()));

        } finally {
            channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
