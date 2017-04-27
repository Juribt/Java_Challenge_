package model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bilovyur on 26.02.2017.
 */
public class Users extends ForwardingSet<UsersData1>{

    private Set<UsersData1> delegate; //создание объекта

    public Users(Users users) {
        this.delegate = new HashSet<UsersData1>(users.delegate());
    }

    public Users(Collection<UsersData1> users) {
        this.delegate = new HashSet<UsersData1>(users);
    }

    public Users() {
        this.delegate = new HashSet<UsersData1>();
    }

    @Override
    protected Set<UsersData1> delegate() {
        return delegate;
    }

    public Users withAdded(UsersData1 user){
        Users users = new Users (this);
        users.add (user);
        return users;

    }

    public Users without(UsersData1 user){
        Users users = new Users (this);
        users.remove (user);
        return users;

    }
}
