package ru.stqa.yuri.addressbook1.model;

/**
 * Created by bilovyur on 26.02.2017.
 */
import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bilovyur on 26.02.2017.
 */
public class Contacts1 extends ForwardingSet<NewContactData2>{

    private Set<NewContactData2> delegate; //создание объекта

    public Contacts1(Contacts1 contacts) {
        this.delegate = new HashSet<NewContactData2>(contacts.delegate());
    }

    public Contacts1(Collection<NewContactData2> contacts) {
        this.delegate = new HashSet<NewContactData2>(contacts);
    }

    public Contacts1() {
        this.delegate = new HashSet<NewContactData2>();
    }

    @Override
    protected Set<NewContactData2> delegate() {
        return delegate;
    }

    public Contacts1 withAdded(NewContactData2 contact){
        Contacts1 contacts = new Contacts1(this);
        contacts.add (contact);
        return contacts;

    }

    public Contacts1 without(NewContactData2 contact){
        Contacts1 contacts = new Contacts1(this);
        contacts.remove (contact);
        return contacts;

    }



}
