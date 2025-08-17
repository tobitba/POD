package ar.edu.itba.pod.server;

import java.time.LocalDate;

public class Book {
    private final String name;
    private final String ISNB;
    private final LocalDate publicationDate;
    private final Author author;

    public Book(String name, String ISNB, LocalDate publicationDate, Author author){
        this.name = name;
        this.ISNB = ISNB;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Book b2 && b2.ISNB.equals(this.ISNB);
    }

    @Override
    public int hashCode() {
        return ISNB.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getISNB() {
        return ISNB;
    }

    public LocalDate getPublicationDate() {
        return publicationDate; //trhead safe?
    }

    public Author getAuthor() {
        return author;
    }
}