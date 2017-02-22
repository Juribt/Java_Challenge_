package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.Comparator;
import java.util.List;

/**
 * Created by bilovyur on 02.02.2017.
 */
//изменение контактов
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void testContactPreconditions() {  //проверка предусловий контактов
        app.goTo().checkNewContact(); //открыть страницу контактов
        if (app.contact().contactlist().size() == 0) { //проверка на то что контактов на странице нет
            app.contact().create_contact(new NewContactData1("Testovich", "Test", "Testyi", "Testik", "Test_High_Technologies", "89526656583", "john_swift@yahoo.com", "England, Solsbery, Flint str, h 7, fl. 8", "6402780", "Yuri1_test_group")); // если нет то создаём
        }

    }

    @Test
    public void testContactModification() {
        List<NewContactData1> before = app.contact().contactlist();
        int index = before.size() - 1;
        NewContactData1 contact = new NewContactData1(before.get(index).getId(), "New_Testovich", "Test2", "Testoviy", "Testik3", "Test_Super_Technologies", "89526656777", "john_gallow@yahoo.com", "Scotland, Solsbery, Flint str, h 7, fl. 8", "6402780", null);
        app.contact().modifyContact(index, contact); //изменение контакта
        List<NewContactData1> after = app.contact().contactlist();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super NewContactData1> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after); //сравнение упорядоченных списков контактов

    }


}
