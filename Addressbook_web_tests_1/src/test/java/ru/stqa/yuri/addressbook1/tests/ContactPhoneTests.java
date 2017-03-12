package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

/**
 * Created by bilovyur on 04.03.2017.
 */
public class ContactPhoneTests extends TestBase {
    @BeforeMethod(enabled = true)
    public void testContactPreconditions() {  //проверка предусловий контактов
        app.goTo().checkNewContact(); //открыть страницу контактов
        if (app.contact().contact_all().size() == 0) { //проверка на то что контактов на странице нет
            app.contact().create_contact(new NewContactData1()
                    .withLast_name("Testovich").withFirst_name("Test").withMiddle_name("Testyi").withNick_name("Testik").withCompany_name("Test_High_Technologies").withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com").withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780").withGroup("Yuri1_test_group")); // если нет то создаём
        }

    }

    @Test
    public void test_newcontact_Tests() {

        NewContactData1 contact = app.contact().contact_all().iterator().next(); //загрузка множества контактов

        NewContactData1 contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка информации о контакте из формы редактирования, выбираем случайный контакт

        //        Contacts before = app.contact().contact_all();  //работа со множествами
    }
}