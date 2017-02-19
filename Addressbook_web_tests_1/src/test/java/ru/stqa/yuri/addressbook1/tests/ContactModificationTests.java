package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;
/**
 * Created by bilovyur on 02.02.2017.
 */
//изменение контактов
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification ()
    {
        app.getNavigationHelper().checkNewContact(); //открыть страницу контактов
        if (!app.getContactHelper().isThereAContact()){ //проверка на то что контактов на странице нет
            app.getContactHelper().createContact(new NewContactData1("Testovich", "Test", "Testyi", "Testik", "Test_High_Technologies", "89526656583", "john_swift@yahoo.com", "England, Solsbery, Flint str, h 7, fl. 8", "6402780","Yuri1_test_group")); // если нет то создаём
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().changeContact(); //изменить контакт
        app.getContactHelper().fillNewContactForm(new NewContactData1("New_Testovich", "Test2", "Testoviy", "Testik3", "Test_Super_Technologies", "89526656777", "john_gallow@yahoo.com", "Scotland, Solsbery, Flint str, h 7, fl. 8", "6402780",null), false);
        app.getContactHelper().updateContact(); //submit updated contact
        app.getContactHelper().checkContact(); // зайти на страницу для проверки
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

           }
}
