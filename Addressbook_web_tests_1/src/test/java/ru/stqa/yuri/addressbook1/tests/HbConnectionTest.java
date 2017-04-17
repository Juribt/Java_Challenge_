package ru.stqa.yuri.addressbook1.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.List;

/**
 * Created by bilovyur on 02.04.2017.
 */
public class HbConnectionTest {


    private SessionFactory sessionFactory;


    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace(); //вывод стектрейса на консоль

            StandardServiceRegistryBuilder.destroy( registry );
        }
    }




    @Test(enabled=true)
    public void testHbConnection(){
       Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData1> result = session.createQuery( "from GroupData1" ).list();
        for ( GroupData1 group : result ) {
            System.out.println( group );
            System.out.println( group.getId() );
            System.out.println(group.getContacts());
            System.out.println(group.getContacts().size());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testHbConnection_contact(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<NewContactData1> result = session.createQuery( "from NewContactData1 where deprecated = '0000-00-00'" ).list();
       for ( NewContactData1 contact : result ) {
            System.out.println( contact );
           System.out.println("Группа: " + contact.getGroups());
           //        System.out.println(contact.getGroups().size());
                  }

        session.getTransaction().commit();
        session.close();

    }

    /*@Test
    public void testHbConnection_contact_group(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<NewContactData1> result = session.createQuery( "from NewContactData1 where deprecated = '0000-00-00'" ).list();
        for ( NewContactData1 contact : result ) {
            System.out.println( contact );
            System.out.println(contact.getGroups());

        }


        session.getTransaction().commit();
        session.close();


    }*/

}
