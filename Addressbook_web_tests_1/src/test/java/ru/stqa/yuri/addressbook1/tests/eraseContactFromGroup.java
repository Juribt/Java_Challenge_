package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 14.04.2017.
 */
public class eraseContactFromGroup extends TestBase {

    private int currentContact;

    @BeforeMethod(enabled = true)
    public void testEraseContactFromGroupPreconditions(){
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

@Test
    public void testEraseContactFromGroup(){

    Groups before = app.db().groups();
    Integer group_Id = 0;
     Set<NewContactData1> page_first = new HashSet<NewContactData1>();
    for ( GroupData1 group : before ) {    //проверка на контакты в группах
             if (group.getContacts().size()>= 1){
            group_Id = group.getId();
                 page_first = group.getContacts();
        }
    }
    app.goTo().checkNewContact();    //удаление контакта из группы
    app.contact().getGroup(group_Id);

    NewContactData1 set_contact = page_first.iterator().next(); //выбираем контакт
    currentContact = set_contact.getId();
    app.contact().changeContactById(currentContact); //ставим галку
    app.contact().removeFromGroup(); //удалим контакт из группы
    Groups after = app.db().groups();
    Set<NewContactData1> page_second = new HashSet<NewContactData1>();
     for ( GroupData1 group : after ) { //смотрим, что поменялось в группе
               if (group.getId()==  group_Id){
                 page_second = group.getContacts();
        }
    }
    assertThat(page_second.size() +1, equalTo(page_first.size())); //проверим, что контакт добавлен и всё ок


}
}

