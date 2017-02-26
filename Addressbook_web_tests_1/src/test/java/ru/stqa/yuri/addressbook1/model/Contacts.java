package ru.stqa.yuri.addressbook1.model;

/**
 * Created by bilovyur on 26.02.2017.
 */
import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bilovyur on 26.02.2017.
 */
public class Contacts extends ForwardingSet<NewContactData1>{

    private Set<NewContactData1> delegate; //создание объекта

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<NewContactData1>(contacts.delegate());
    }

    public Contacts() {
        this.delegate = new HashSet<NewContactData1>();
    }

    @Override
    protected Set<NewContactData1> delegate() {
        return delegate;
    }

    public Contacts withAdded(NewContactData1 contact){
        Contacts contacts = new Contacts (this);
        contacts.add (contact);
        return contacts;

    }

    public Contacts without(NewContactData1 contact){
        Contacts contacts = new Contacts (this);
        contacts.remove (contact);
        return contacts;

    }
}
