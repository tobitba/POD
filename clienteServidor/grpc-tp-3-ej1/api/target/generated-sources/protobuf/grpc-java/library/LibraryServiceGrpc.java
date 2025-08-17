package library;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: library/library.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LibraryServiceGrpc {

  private LibraryServiceGrpc() {}

  public static final String SERVICE_NAME = "library.LibraryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      library.Library.ListBooksResponse> getListBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBooks",
      requestType = com.google.protobuf.Empty.class,
      responseType = library.Library.ListBooksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      library.Library.ListBooksResponse> getListBooksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, library.Library.ListBooksResponse> getListBooksMethod;
    if ((getListBooksMethod = LibraryServiceGrpc.getListBooksMethod) == null) {
      synchronized (LibraryServiceGrpc.class) {
        if ((getListBooksMethod = LibraryServiceGrpc.getListBooksMethod) == null) {
          LibraryServiceGrpc.getListBooksMethod = getListBooksMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, library.Library.ListBooksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  library.Library.ListBooksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LibraryServiceMethodDescriptorSupplier("ListBooks"))
              .build();
        }
      }
    }
    return getListBooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      library.Library.LendBookResponse> getLendBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LendBook",
      requestType = com.google.protobuf.StringValue.class,
      responseType = library.Library.LendBookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      library.Library.LendBookResponse> getLendBookMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, library.Library.LendBookResponse> getLendBookMethod;
    if ((getLendBookMethod = LibraryServiceGrpc.getLendBookMethod) == null) {
      synchronized (LibraryServiceGrpc.class) {
        if ((getLendBookMethod = LibraryServiceGrpc.getLendBookMethod) == null) {
          LibraryServiceGrpc.getLendBookMethod = getLendBookMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, library.Library.LendBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LendBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  library.Library.LendBookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LibraryServiceMethodDescriptorSupplier("LendBook"))
              .build();
        }
      }
    }
    return getLendBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<library.Library.LendBookResponse,
      com.google.protobuf.Empty> getReturnBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReturnBook",
      requestType = library.Library.LendBookResponse.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<library.Library.LendBookResponse,
      com.google.protobuf.Empty> getReturnBookMethod() {
    io.grpc.MethodDescriptor<library.Library.LendBookResponse, com.google.protobuf.Empty> getReturnBookMethod;
    if ((getReturnBookMethod = LibraryServiceGrpc.getReturnBookMethod) == null) {
      synchronized (LibraryServiceGrpc.class) {
        if ((getReturnBookMethod = LibraryServiceGrpc.getReturnBookMethod) == null) {
          LibraryServiceGrpc.getReturnBookMethod = getReturnBookMethod =
              io.grpc.MethodDescriptor.<library.Library.LendBookResponse, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReturnBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  library.Library.LendBookResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new LibraryServiceMethodDescriptorSupplier("ReturnBook"))
              .build();
        }
      }
    }
    return getReturnBookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LibraryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LibraryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LibraryServiceStub>() {
        @java.lang.Override
        public LibraryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LibraryServiceStub(channel, callOptions);
        }
      };
    return LibraryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LibraryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LibraryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LibraryServiceBlockingStub>() {
        @java.lang.Override
        public LibraryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LibraryServiceBlockingStub(channel, callOptions);
        }
      };
    return LibraryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LibraryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LibraryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LibraryServiceFutureStub>() {
        @java.lang.Override
        public LibraryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LibraryServiceFutureStub(channel, callOptions);
        }
      };
    return LibraryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void listBooks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<library.Library.ListBooksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBooksMethod(), responseObserver);
    }

    /**
     */
    default void lendBook(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<library.Library.LendBookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLendBookMethod(), responseObserver);
    }

    /**
     */
    default void returnBook(library.Library.LendBookResponse request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReturnBookMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LibraryService.
   */
  public static abstract class LibraryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LibraryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LibraryService.
   */
  public static final class LibraryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LibraryServiceStub> {
    private LibraryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LibraryServiceStub(channel, callOptions);
    }

    /**
     */
    public void listBooks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<library.Library.ListBooksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBooksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lendBook(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<library.Library.LendBookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLendBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void returnBook(library.Library.LendBookResponse request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReturnBookMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LibraryService.
   */
  public static final class LibraryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LibraryServiceBlockingStub> {
    private LibraryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LibraryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public library.Library.ListBooksResponse listBooks(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBooksMethod(), getCallOptions(), request);
    }

    /**
     */
    public library.Library.LendBookResponse lendBook(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLendBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty returnBook(library.Library.LendBookResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReturnBookMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LibraryService.
   */
  public static final class LibraryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LibraryServiceFutureStub> {
    private LibraryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LibraryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<library.Library.ListBooksResponse> listBooks(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBooksMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<library.Library.LendBookResponse> lendBook(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLendBookMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> returnBook(
        library.Library.LendBookResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReturnBookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_BOOKS = 0;
  private static final int METHODID_LEND_BOOK = 1;
  private static final int METHODID_RETURN_BOOK = 2;

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
        case METHODID_LIST_BOOKS:
          serviceImpl.listBooks((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<library.Library.ListBooksResponse>) responseObserver);
          break;
        case METHODID_LEND_BOOK:
          serviceImpl.lendBook((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<library.Library.LendBookResponse>) responseObserver);
          break;
        case METHODID_RETURN_BOOK:
          serviceImpl.returnBook((library.Library.LendBookResponse) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getListBooksMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              library.Library.ListBooksResponse>(
                service, METHODID_LIST_BOOKS)))
        .addMethod(
          getLendBookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              library.Library.LendBookResponse>(
                service, METHODID_LEND_BOOK)))
        .addMethod(
          getReturnBookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              library.Library.LendBookResponse,
              com.google.protobuf.Empty>(
                service, METHODID_RETURN_BOOK)))
        .build();
  }

  private static abstract class LibraryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LibraryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return library.Library.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LibraryService");
    }
  }

  private static final class LibraryServiceFileDescriptorSupplier
      extends LibraryServiceBaseDescriptorSupplier {
    LibraryServiceFileDescriptorSupplier() {}
  }

  private static final class LibraryServiceMethodDescriptorSupplier
      extends LibraryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LibraryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LibraryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LibraryServiceFileDescriptorSupplier())
              .addMethod(getListBooksMethod())
              .addMethod(getLendBookMethod())
              .addMethod(getReturnBookMethod())
              .build();
        }
      }
    }
    return result;
  }
}
