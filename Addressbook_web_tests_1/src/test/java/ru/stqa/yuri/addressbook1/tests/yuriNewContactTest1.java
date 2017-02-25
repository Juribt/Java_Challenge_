package ru.stqa.yuri.addressbook1.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.Comparator;
import java.util.List;


/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriNewContactTest1 extends TestBase {

    //тест создание нового контакта
    @Test
    public void test_newcontact_Tests() {
        app.contact().checkContact(); //зайти на страницу контактов
        List<NewContactData1> before = app.contact().contactlist(); //список контактов до
        NewContactData1 contact = new NewContactData1()
                .withLast_name("Testovich5").withFirst_name("Test").withMiddle_name("Testyi").withNick_name("Testik").withCompany_name("Test_High_Technologies").withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com").withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780").withGroup("Yuri1_test_group");

        app.contact().create_contact(contact);
        List<NewContactData1> after = app.contact().contactlist(); //список контактов после

        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);

        Comparator<? super NewContactData1> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after); //сравнение упорядоченных списков контактов


    }


}
