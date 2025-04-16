package org.example.server;

import ar.edu.itba.pod.grpc.user.LoginInformation;
import ar.edu.itba.pod.grpc.user.User;
import ar.edu.itba.pod.grpc.user.UserRoles;
import ar.edu.itba.pod.grpc.user.UserServiceGrpc;
import com.google.protobuf.BoolValue;
import io.grpc.stub.StreamObserver;

import java.util.*;

public class UserServant extends UserServiceGrpc.UserServiceImplBase {

    private final Map<String,User> pepes = new HashMap<>();

    private static class UserPepes {
        private final User user;
        UserPepes(User user) {this.user = user;}

        @Override
        public int hashCode() {
            return Objects.hash(user.getUserName());
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof UserPepes pepe && user.getId() == pepe.user.getId();
        }
    }

    @Override
    public void register(User request, StreamObserver<BoolValue> responseObserver) {
        pepes.put(request.getUserName(),request);
        responseObserver.onNext(BoolValue.of(true));
        responseObserver.onCompleted();
    }

    @Override
    public void doLogin(LoginInformation request, StreamObserver<User> responseObserver) {
        User toRet = pepes.get(request.getUserName());
        responseObserver.onNext(toRet);
        responseObserver.onCompleted();
    }

    @Override
    public void getRoles(User request, StreamObserver<UserRoles> responseObserver) {
        responseObserver.onNext(UserRoles.newBuilder().build());   //TODO: como lo creo
        responseObserver.onCompleted();
    }
}
