package ru.stqa.yuri.addressbook1.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;

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
}
