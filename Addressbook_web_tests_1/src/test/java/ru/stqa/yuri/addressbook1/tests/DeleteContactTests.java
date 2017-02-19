package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

/**
 * Created by bilovyur on 02.02.2017.
 */
//1-й тест на удаление контакта
public class DeleteContactTests extends TestBase {

    @Test
    public void testContactDeletion ()
    {
        app.getNavigationHelper().checkNewContact(); //открыть страницу контактов
        if (!app.getContactHelper().isThereAContact()){ //проверка на то что контактов на странице нет
          app.getContactHelper().createContact(new NewContactData1("Testovich", "Test", "Testyi", "Testik", "Test_High_Technologies", "89526656583", "john_swift@yahoo.com", "England, Solsbery, Flint str, h 7, fl. 8", "6402780","Yuri1_test_group")); // если нет то создаём
        }
        int before = app.getContactHelper().getContactCount(); //проверка на кол-во групп на странице в начале
        app.getContactHelper().changeContact(); //открыть окно на изменение
        app.getContactHelper().deleteContact(); //удаление контакта
        app.getContactHelper().checkContact(); //зайти снова на страницу контактов
        int after = app.getContactHelper().getContactCount(); //проверка на кол-во групп на странице в конце
        Assert.assertEquals(after, before-1);
    }


}
