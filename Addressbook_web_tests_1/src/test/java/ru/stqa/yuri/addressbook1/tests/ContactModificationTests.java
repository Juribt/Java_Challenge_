package ru.stqa.yuri.addressbook1.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.NewContactData1;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by bilovyur on 02.02.2017.
 */
//изменение контактов
public class ContactModificationTests extends TestBase {

    @BeforeMethod(enabled = false)
    public void testContactPreconditions() {  //проверка предусловий контактов
        app.goTo().checkNewContact(); //открыть страницу контактов
        if (app.contact().contact_all().size() == 0) { //проверка на то что контактов на странице нет
            app.contact().create_contact(new NewContactData1()
                    .withLast_name("Testovich").withFirst_name("Test").withMiddle_name("Testyi").withNick_name("Testik").withCompany_name("Test_High_Technologies").withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com").withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780").withGroup("Yuri1_test_group")); // если нет то создаём
        }

    }

    @Test(enabled = false)
    public void testContactModification() {
        Contacts before = app.contact().contact_all();
        NewContactData1 modifiedContact = before.iterator().next();

        NewContactData1 contact = new NewContactData1()
                .withId(modifiedContact.getId()).withLast_name("New_Testovich").withFirst_name("Test2").withMiddle_name("Testoviy").withNick_name("Testik3").withCompany_name("Test_Super_Technologies").withMobile_phone("89526656777").withEmail_1("john_gallow@yahoo.com").withAddress("Scotland, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780");
        app.contact().modifyContact(contact); //изменение контакта
        Contacts after = app.contact().contact_all();

        assertEquals(after.size(), before.size()); // количество контактов не изменилось
      //  assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
