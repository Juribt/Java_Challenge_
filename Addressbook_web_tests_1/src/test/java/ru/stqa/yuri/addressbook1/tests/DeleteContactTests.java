package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;
import java.util.Set;

/**
 * Created by bilovyur on 02.02.2017.
 */
//1-й тест на удаление контакта
public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void testContactPreconditions() { //проверка предусловий контактов
        app.goTo().checkNewContact(); //открыть страницу контактов
        if (app.contact().contact_all().size() == 0) { //проверка на то что контактов на странице нет
            app.contact().create_contact(new NewContactData1()
                    .withLast_name("Testovich").withFirst_name("Test").withMiddle_name("Testyi").withNick_name("Testik").withCompany_name("Test_High_Technologies").withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com").withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780").withGroup("Yuri1_test_group")); // если нет то создаём
        }
    }

    @Test
    public void testContactDeletion() {

        Set<NewContactData1> before = app.contact().contact_all();
        NewContactData1 deletedContact = before.iterator().next();



        app.contact().delete_contact(deletedContact);

        Set<NewContactData1> after = app.contact().contact_all();

        Assert.assertEquals(after.size(), before.size() - 1); //проверка на количество контактов в списке
        before.remove(deletedContact); //список контактов должен быть одинаковым с after

        Assert.assertEquals(before, after); //проверка списков до и после удаления

    }



}
