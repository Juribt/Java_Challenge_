package ru.stqa.yuri.addressbook1.tests;

import org.openqa.selenium.By;
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
        app.getContactHelper().checkNewContact(); //открыть страницу контактов
        app.getContactHelper().changeContact(); //изменить контакт
        app.getContactHelper().fillNewContactForm(new NewContactData1("New_Testovich", "Test2", "Testoviy", "Testik3", "Test_Super_Technologies", "89526656777", "john_gallow@yahoo.com", "Scotland, Solsbery, Flint str, h 7, fl. 8", "6402780"));
        app.getContactHelper().updateContact(); //submit updated contact
           }
}
