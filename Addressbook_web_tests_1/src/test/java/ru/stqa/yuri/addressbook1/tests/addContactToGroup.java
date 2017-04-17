package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 14.04.2017.
 */
public class addContactToGroup extends TestBase{
    private int currentContact;
//проверить есть ли группа,. если нет то создать

    @BeforeMethod(enabled = true)
    public void testaddToGroupContactPreconditions(){
        if (app.db().groups().size()== 0){
            app.goTo().groupPage();
            app.group().create(new GroupData1().withNameGroup("Yuri1_test_group")); // если нет то создаём
        }
        if (app.db().contacts().size()==0){
            app.goTo().checkNewContact();
            app.contact().create_contact(new NewContactData1()
                    .withLast_name("Testovich").withFirst_name("Test").withMiddle_name("Testyi").withNick_name("Testik").withCompany_name("Test_High_Technologies").withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com").withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780"));
                   }
    }

    @Test(enabled = true)
    public void testaddToGroupContact(){
        app.goTo().checkNewContact(); //Открываем страницу
        Contacts before = app.db().contacts();
        NewContactData1 addedContact = before.iterator().next(); //выбираем контакт
        currentContact = addedContact.getId();
        app.contact().changeContactById(currentContact); //ставим галку
        app.contact().addContactToGroup(); //нажать кнопку add to
        Contacts after = app.db().contacts();
        //проверить, что группа добавилась к контакту
        if (before.iterator().next().getGroups().size()+1 != after.iterator().next().getGroups().size() ){ //если не равно, значит не добавилась создадим новую группу
            app.goTo().groupPage();
            long unixTime = System.currentTimeMillis() / 1000L;
            String newGroupName = "Yuri1_created_group_for_contact_" +unixTime;
            app.group().create(new GroupData1().withNameGroup(newGroupName));
//добавляем контакт в новую группу
            app.goTo().checkNewContact();
            before = app.db().contacts();
            app.contact().changeContactById(currentContact); //ставим галку
            app.contact().clickOption(newGroupName); // выберем новую группу
            app.contact().addContactToGroup(); // добавим контакт
            after = app.db().contacts();
            assertThat(after.iterator().next().getGroups().size(), equalTo(before.iterator().next().getGroups().size()+1)); //проверим, что контакт добавлен и всё ок

        }else {
            assertThat(after.iterator().next().getGroups().size(), equalTo(before.iterator().next().getGroups().size()+1)); //контакт к группе был добавлен всё ок
        }

    }
}
