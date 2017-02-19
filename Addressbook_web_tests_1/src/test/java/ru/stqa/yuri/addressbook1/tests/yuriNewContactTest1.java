package ru.stqa.yuri.addressbook1.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.List;


/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriNewContactTest1 extends TestBase {

    //тест создание нового контакта
    @Test
    public void test_newcontact_Tests() {
        app.getContactHelper().checkContact(); //зайти на страницу контактов
        List<NewContactData1> before = app.getContactHelper().getContactList(); //список контактов до
     //   int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new NewContactData1("Testovich", "Test", "Testyi", "Testik", "Test_High_Technologies", "89526656583", "john_swift@yahoo.com", "England, Solsbery, Flint str, h 7, fl. 8", "6402780","Yuri1_test_group"));
        List<NewContactData1> after = app.getContactHelper().getContactList(); //список контактов после
     //   int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size()+1);

    }


}
