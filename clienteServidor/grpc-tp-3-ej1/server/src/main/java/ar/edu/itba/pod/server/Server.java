package ar.edu.itba.pod.server;

import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private static Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws InterruptedException, IOException {
        logger.info(" Server Starting ...");

        int port = 50051;


        io.grpc.Server server = ServerBuilder.forPort(port)
                .build();
        server.start();
        logger.info("Server started, listening on " + port);
        server.awaitTermination();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down gRPC server since JVM is shutting down");
            server.shutdown();
            logger.info("Server shut down");
        }));
    }

    private Map<Book, Integer> library() {
        Collection<String[]> books = List.of(
                new String[]{"3", "978-0345533487", "A Knight of the Seven Kingdoms", "2015-10-06", "Martin", "George R. R."},
                new String[]{"4", "978-0441294671", "God Emperor of Dune", "1987-06-15", "Herbert", "Frank"},
                new String[]{"2", "978-0451210845", "The Gunslinger", "2003-07-01", "King", "Stephen"},
                new String[]{
                        "5",
                        "978-0307292063",
                        "The Foundation Trilogy", "2011 - 11 - 25", " Asimov", " Isaac"},
                new String[]{"4", "978-0765351494", "Sandworms of Dune",
                        "2008-07-01", "Herbert", "Brian"},
                new String[]             {        "1",        "978-0307743657",                 "The Shining", "2012-06-26", "King", "Stephen"},
                new String[]{"2", "978-0553328257", "The Complete Sherlock Holmes", "1986 - 10 - 01", " Conan Doyle", " Arthur"});

        Map<Book, Integer> library = new HashMap<>();
        books.forEach(stringBook -> {
            Book book = new Book(stringBook[2],stringBook[1], LocalDate.parse(stringBook[3]), new Author(stringBook[4],stringBook[5]));
            library.put(book,Integer.valueOf(stringBook[0]));
        });

        return library;
    }



}
