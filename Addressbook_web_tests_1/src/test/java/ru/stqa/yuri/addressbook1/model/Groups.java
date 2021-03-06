package ru.stqa.yuri.addressbook1.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bilovyur on 26.02.2017.
 */
public class Groups extends ForwardingSet<GroupData1>{

    private Set<GroupData1> delegate; //создание объекта

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData1>(groups.delegate());
    }

    public Groups(Collection<GroupData1> groups) {
        this.delegate = new HashSet<GroupData1>(groups);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData1>();
    }

    @Override
    protected Set<GroupData1> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData1 group){
        Groups groups = new Groups (this);
        groups.add (group);
        return groups;

    }

    public Groups without(GroupData1 group){
        Groups groups = new Groups (this);
        groups.remove (group);
        return groups;

    }
}
