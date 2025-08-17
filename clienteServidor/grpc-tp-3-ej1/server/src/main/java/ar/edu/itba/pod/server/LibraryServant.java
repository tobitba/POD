package ar.edu.itba.pod.server;

import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;
import library.Library;
import library.LibraryServiceGrpc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LibraryServant extends LibraryServiceGrpc.LibraryServiceImplBase {

    private final Map<Book,Integer> library = new HashMap<>();

    public LibraryServant(){

    }

    @Override
    public void listBooks(Empty request, StreamObserver<Library.ListBooksResponse> responseObserver) {
        super.listBooks(request, responseObserver);
    }

    @Override
    public void lendBook(StringValue request, StreamObserver<Library.LendBookResponse> responseObserver) {
        super.lendBook(request, responseObserver);
    }

    @Override
    public void returnBook(Library.LendBookResponse request, StreamObserver<Empty> responseObserver) {
        super.returnBook(request, responseObserver);
    }





}
