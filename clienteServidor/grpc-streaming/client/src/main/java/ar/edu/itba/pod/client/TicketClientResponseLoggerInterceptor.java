package ar.edu.itba.pod.client;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketClientResponseLoggerInterceptor implements ClientInterceptor {
    Logger logger =  LoggerFactory.getLogger(TicketClientResponseLoggerInterceptor.class);
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<>(
                channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
               // logger.info("Setting userToken in header");
                                                            // Here goes your code
                super.start(responseListener, headers);
            }
        };
    }
}
