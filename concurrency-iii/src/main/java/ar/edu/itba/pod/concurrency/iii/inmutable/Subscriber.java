package ar.edu.itba.pod.concurrency.iii.inmutable;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Subscriber {
    private final Integer id;
    private final String fullName;
    private final Date dateOfBirth;
    private final List<Subscription> subscriptions;

    public Subscriber(Integer id, String fullName, Date dateOfBirth,  List<Subscription> subscriptions) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.subscriptions = subscriptions;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }

    public List<Subscription> getSubscriptions() {
        return new LinkedList<>(subscriptions);
    } //TODO: preguntar como hacia con la lista xd esto no esta copado creo
}
