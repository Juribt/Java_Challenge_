package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;

/**
 * Created by bilovyur on 03.02.2017.
 */
//2-й тест на удаление контакта
public class DeleteContactTests_1 extends TestBase {

    @Test
    public void testContactDeletion () {
        app.getContactHelper().checkNewContact(); //открыть страницу контактов
        app.getContactHelper().makeSelectedContact(); // select first contact
        app.getContactHelper().deleteContact_1(); // second variant of deletion
        app.getContactHelper().checkNewContact(); //открыть страницу контактов
    }
}
