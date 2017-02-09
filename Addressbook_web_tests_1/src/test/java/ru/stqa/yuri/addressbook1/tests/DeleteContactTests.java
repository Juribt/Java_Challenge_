package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;

/**
 * Created by bilovyur on 02.02.2017.
 */
//1-й тест на удаление контакта
public class DeleteContactTests extends TestBase {

    @Test
    public void testContactDeletion ()
    {
        app.getNavigationHelper().checkNewContact(); //открыть страницу контактов
        app.getContactHelper().changeContact(); //открыть окно на изменение
        app.getContactHelper().deleteContact(); //удаление контакта
    }


}
