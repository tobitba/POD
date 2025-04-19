package ar.edu.itba.pod.server.ticket.repository;

public record Train(
        String id,
        String destination,
        String time,
        int availableSeats
) {
}
