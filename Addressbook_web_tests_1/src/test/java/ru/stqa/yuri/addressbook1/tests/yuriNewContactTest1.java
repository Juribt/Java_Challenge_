package ru.stqa.yuri.addressbook1.tests;


import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;


/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriNewContactTest1 extends TestBase {

    //тест создание нового контакта
    @Test
    public void test_newcontact_Tests() {
        app.getContactHelper().createNewContact();

        app.getContactHelper().fillNewContactForm(new NewContactData1("Testovich", "Test", "Testyi", "Testik", "Test_High_Technologies", "89526656583", "john_swift@yahoo.com", "England, Solsbery, Flint str, h 7, fl. 8", "6402780"));
        app.getContactHelper().checkNewContact();
    }


}
