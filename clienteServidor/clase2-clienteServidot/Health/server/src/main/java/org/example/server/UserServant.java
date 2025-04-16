package org.example.server;

import ar.edu.itba.pod.grpc.user.*;
import com.google.protobuf.BoolValue;
import io.grpc.stub.StreamObserver;

import java.util.*;

public class UserServant extends UserServiceGrpc.UserServiceImplBase {

    private final Map<String,User> pepes = new HashMap<>();
    private final UserRoles roles;

    public UserServant(){
        UserRoles.Builder rolesBuilder = UserRoles.newBuilder();
        for(Role role : Role.values()){
            if(role != Role.UNRECOGNIZED) {

            rolesBuilder.putRolesBySite(role.name(),role);
            }
        }
        roles = rolesBuilder.build();
    }

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
        responseObserver.onNext(roles);   //TODO: como lo creo
        responseObserver.onCompleted();
    }
}
