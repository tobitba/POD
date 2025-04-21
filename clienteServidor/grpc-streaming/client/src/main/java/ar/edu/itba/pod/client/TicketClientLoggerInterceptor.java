package ar.edu.itba.pod.client;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Este interceptor lo que va a hacer es interceptar la llamada al metodo ANTES de que se efectue la comunicacion, osea justo cuando
 * se hace stub.methodCall(...)
 */
public class TicketClientLoggerInterceptor implements ClientInterceptor {
    Logger logger =  LoggerFactory.getLogger(TicketClientLoggerInterceptor.class);
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        String methodName = methodDescriptor.getBareMethodName();
        String serviceName = methodDescriptor.getServiceName();
        logger.info("Llamando al servicio {} metodo {}",serviceName,methodName);
        return channel.newCall(methodDescriptor,callOptions);
    }
}
