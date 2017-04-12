package ru.stqa.yuri.addressbook1.tests;



import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.Groups;
import ru.stqa.yuri.addressbook1.model.NewContactData1;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriNewContactTest1 extends TestBase {

    //тест создание нового контакта
    @Test(enabled = true)
    public void test_newcontact_Tests() {
        app.contact().checkContact(); //зайти на страницу контактов
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();  //работа со множествами
  //     Contacts before = app.contact().contact_all();
        NewContactData1 contact = new NewContactData1()
                .withLast_name("Testovich5")
                .withFirst_name("Test")
                .withMiddle_name("Testyi")
                .withNick_name("Testik")
                .withCompany_name("Test_High_Technologies")
                .withMobile_phone("89526656583")
                .withEmail_1("john_swift@yahoo.com")
                .withAddress("England, Solsbery, Flint str, h 7, fl. 8")
                .withHome_phone("6402780").inGroup(groups.iterator().next());
//                .withGroup("Yuri1_test_group");


        app.contact().create_contact(contact);
        Contacts after = app.db().contacts();//список контактов после

        assertThat(after.size(), equalTo(before.size() + 1));


        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt())))); //проверка множеств через Hamcrest


    }


}
