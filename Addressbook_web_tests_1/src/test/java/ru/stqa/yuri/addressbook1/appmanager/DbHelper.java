package ru.stqa.yuri.addressbook1.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.yuri.addressbook1.model.*;

import java.util.List;

/**
 * Created by bilovyur on 07.04.2017.
 */
public class DbHelper {


    private final SessionFactory sessionFactory;

    public DbHelper (){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();


    }
    public Groups groups(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData1> result = session.createQuery( "from GroupData1" ).list();
        //    for ( GroupData1 group : result ) {
        //     System.out.println( group );
        //    }
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Contacts contacts(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<NewContactData1> result = session.createQuery( "from NewContactData1 where deprecated = '0000-00-00'" ).list();

        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }

/*    public ContactToGroup contacts_groups(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<ContactToGroup> result = session.createQuery( "from ContactToGroup" ).list();

        session.getTransaction().commit();
        session.close();
        return new ContactToGroup(result);
    }*/
}
