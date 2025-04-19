package ar.edu.itba.pod.grpc.trainTickets;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: trainTicketService/train_ticket_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrainTicketServiceGrpc {

  private TrainTicketServiceGrpc() {}

  public static final String SERVICE_NAME = "trainTicketService.TrainTicketService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ar.edu.itba.pod.grpc.trainTickets.Destinations> getGetDestinationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDestinations",
      requestType = com.google.protobuf.Empty.class,
      responseType = ar.edu.itba.pod.grpc.trainTickets.Destinations.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ar.edu.itba.pod.grpc.trainTickets.Destinations> getGetDestinationsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ar.edu.itba.pod.grpc.trainTickets.Destinations> getGetDestinationsMethod;
    if ((getGetDestinationsMethod = TrainTicketServiceGrpc.getGetDestinationsMethod) == null) {
      synchronized (TrainTicketServiceGrpc.class) {
        if ((getGetDestinationsMethod = TrainTicketServiceGrpc.getGetDestinationsMethod) == null) {
          TrainTicketServiceGrpc.getGetDestinationsMethod = getGetDestinationsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ar.edu.itba.pod.grpc.trainTickets.Destinations>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDestinations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ar.edu.itba.pod.grpc.trainTickets.Destinations.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketServiceMethodDescriptorSupplier("GetDestinations"))
              .build();
        }
      }
    }
    return getGetDestinationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ar.edu.itba.pod.grpc.trainTickets.Train> getGetTrainsForDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrainsForDestination",
      requestType = com.google.protobuf.StringValue.class,
      responseType = ar.edu.itba.pod.grpc.trainTickets.Train.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ar.edu.itba.pod.grpc.trainTickets.Train> getGetTrainsForDestinationMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, ar.edu.itba.pod.grpc.trainTickets.Train> getGetTrainsForDestinationMethod;
    if ((getGetTrainsForDestinationMethod = TrainTicketServiceGrpc.getGetTrainsForDestinationMethod) == null) {
      synchronized (TrainTicketServiceGrpc.class) {
        if ((getGetTrainsForDestinationMethod = TrainTicketServiceGrpc.getGetTrainsForDestinationMethod) == null) {
          TrainTicketServiceGrpc.getGetTrainsForDestinationMethod = getGetTrainsForDestinationMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, ar.edu.itba.pod.grpc.trainTickets.Train>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrainsForDestination"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ar.edu.itba.pod.grpc.trainTickets.Train.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketServiceMethodDescriptorSupplier("GetTrainsForDestination"))
              .build();
        }
      }
    }
    return getGetTrainsForDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ar.edu.itba.pod.grpc.trainTickets.Ticket,
      ar.edu.itba.pod.grpc.trainTickets.Reservation> getPurchaseTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurchaseTicket",
      requestType = ar.edu.itba.pod.grpc.trainTickets.Ticket.class,
      responseType = ar.edu.itba.pod.grpc.trainTickets.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ar.edu.itba.pod.grpc.trainTickets.Ticket,
      ar.edu.itba.pod.grpc.trainTickets.Reservation> getPurchaseTicketMethod() {
    io.grpc.MethodDescriptor<ar.edu.itba.pod.grpc.trainTickets.Ticket, ar.edu.itba.pod.grpc.trainTickets.Reservation> getPurchaseTicketMethod;
    if ((getPurchaseTicketMethod = TrainTicketServiceGrpc.getPurchaseTicketMethod) == null) {
      synchronized (TrainTicketServiceGrpc.class) {
        if ((getPurchaseTicketMethod = TrainTicketServiceGrpc.getPurchaseTicketMethod) == null) {
          TrainTicketServiceGrpc.getPurchaseTicketMethod = getPurchaseTicketMethod =
              io.grpc.MethodDescriptor.<ar.edu.itba.pod.grpc.trainTickets.Ticket, ar.edu.itba.pod.grpc.trainTickets.Reservation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurchaseTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ar.edu.itba.pod.grpc.trainTickets.Ticket.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ar.edu.itba.pod.grpc.trainTickets.Reservation.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketServiceMethodDescriptorSupplier("PurchaseTicket"))
              .build();
        }
      }
    }
    return getPurchaseTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ar.edu.itba.pod.grpc.trainTickets.Reservation,
      ar.edu.itba.pod.grpc.trainTickets.Ticket> getGetTicketsForReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTicketsForReservations",
      requestType = ar.edu.itba.pod.grpc.trainTickets.Reservation.class,
      responseType = ar.edu.itba.pod.grpc.trainTickets.Ticket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ar.edu.itba.pod.grpc.trainTickets.Reservation,
      ar.edu.itba.pod.grpc.trainTickets.Ticket> getGetTicketsForReservationsMethod() {
    io.grpc.MethodDescriptor<ar.edu.itba.pod.grpc.trainTickets.Reservation, ar.edu.itba.pod.grpc.trainTickets.Ticket> getGetTicketsForReservationsMethod;
    if ((getGetTicketsForReservationsMethod = TrainTicketServiceGrpc.getGetTicketsForReservationsMethod) == null) {
      synchronized (TrainTicketServiceGrpc.class) {
        if ((getGetTicketsForReservationsMethod = TrainTicketServiceGrpc.getGetTicketsForReservationsMethod) == null) {
          TrainTicketServiceGrpc.getGetTicketsForReservationsMethod = getGetTicketsForReservationsMethod =
              io.grpc.MethodDescriptor.<ar.edu.itba.pod.grpc.trainTickets.Reservation, ar.edu.itba.pod.grpc.trainTickets.Ticket>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTicketsForReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ar.edu.itba.pod.grpc.trainTickets.Reservation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ar.edu.itba.pod.grpc.trainTickets.Ticket.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketServiceMethodDescriptorSupplier("GetTicketsForReservations"))
              .build();
        }
      }
    }
    return getGetTicketsForReservationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrainTicketServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainTicketServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainTicketServiceStub>() {
        @java.lang.Override
        public TrainTicketServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainTicketServiceStub(channel, callOptions);
        }
      };
    return TrainTicketServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrainTicketServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainTicketServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainTicketServiceBlockingStub>() {
        @java.lang.Override
        public TrainTicketServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainTicketServiceBlockingStub(channel, callOptions);
        }
      };
    return TrainTicketServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrainTicketServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainTicketServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainTicketServiceFutureStub>() {
        @java.lang.Override
        public TrainTicketServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainTicketServiceFutureStub(channel, callOptions);
        }
      };
    return TrainTicketServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getDestinations(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Destinations> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDestinationsMethod(), responseObserver);
    }

    /**
     */
    default void getTrainsForDestination(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Train> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrainsForDestinationMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Ticket> purchaseTicket(
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Reservation> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPurchaseTicketMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Reservation> getTicketsForReservations(
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Ticket> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetTicketsForReservationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TrainTicketService.
   */
  public static abstract class TrainTicketServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TrainTicketServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TrainTicketService.
   */
  public static final class TrainTicketServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TrainTicketServiceStub> {
    private TrainTicketServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainTicketServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainTicketServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDestinations(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Destinations> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDestinationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTrainsForDestination(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Train> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetTrainsForDestinationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Ticket> purchaseTicket(
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Reservation> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPurchaseTicketMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Reservation> getTicketsForReservations(
        io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Ticket> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetTicketsForReservationsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TrainTicketService.
   */
  public static final class TrainTicketServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TrainTicketServiceBlockingStub> {
    private TrainTicketServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainTicketServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainTicketServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ar.edu.itba.pod.grpc.trainTickets.Destinations getDestinations(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDestinationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ar.edu.itba.pod.grpc.trainTickets.Train> getTrainsForDestination(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetTrainsForDestinationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TrainTicketService.
   */
  public static final class TrainTicketServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TrainTicketServiceFutureStub> {
    private TrainTicketServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainTicketServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainTicketServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ar.edu.itba.pod.grpc.trainTickets.Destinations> getDestinations(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDestinationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DESTINATIONS = 0;
  private static final int METHODID_GET_TRAINS_FOR_DESTINATION = 1;
  private static final int METHODID_PURCHASE_TICKET = 2;
  private static final int METHODID_GET_TICKETS_FOR_RESERVATIONS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DESTINATIONS:
          serviceImpl.getDestinations((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Destinations>) responseObserver);
          break;
        case METHODID_GET_TRAINS_FOR_DESTINATION:
          serviceImpl.getTrainsForDestination((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Train>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PURCHASE_TICKET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.purchaseTicket(
              (io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Reservation>) responseObserver);
        case METHODID_GET_TICKETS_FOR_RESERVATIONS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getTicketsForReservations(
              (io.grpc.stub.StreamObserver<ar.edu.itba.pod.grpc.trainTickets.Ticket>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetDestinationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              ar.edu.itba.pod.grpc.trainTickets.Destinations>(
                service, METHODID_GET_DESTINATIONS)))
        .addMethod(
          getGetTrainsForDestinationMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              ar.edu.itba.pod.grpc.trainTickets.Train>(
                service, METHODID_GET_TRAINS_FOR_DESTINATION)))
        .addMethod(
          getPurchaseTicketMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              ar.edu.itba.pod.grpc.trainTickets.Ticket,
              ar.edu.itba.pod.grpc.trainTickets.Reservation>(
                service, METHODID_PURCHASE_TICKET)))
        .addMethod(
          getGetTicketsForReservationsMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              ar.edu.itba.pod.grpc.trainTickets.Reservation,
              ar.edu.itba.pod.grpc.trainTickets.Ticket>(
                service, METHODID_GET_TICKETS_FOR_RESERVATIONS)))
        .build();
  }

  private static abstract class TrainTicketServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrainTicketServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ar.edu.itba.pod.grpc.trainTickets.TrainTicketServiceModel.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrainTicketService");
    }
  }

  private static final class TrainTicketServiceFileDescriptorSupplier
      extends TrainTicketServiceBaseDescriptorSupplier {
    TrainTicketServiceFileDescriptorSupplier() {}
  }

  private static final class TrainTicketServiceMethodDescriptorSupplier
      extends TrainTicketServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrainTicketServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrainTicketServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrainTicketServiceFileDescriptorSupplier())
              .addMethod(getGetDestinationsMethod())
              .addMethod(getGetTrainsForDestinationMethod())
              .addMethod(getPurchaseTicketMethod())
              .addMethod(getGetTicketsForReservationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
