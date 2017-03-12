package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 09.03.2017.
 */
public class newContactTestFile1 extends TestBase {

    @Test(enabled = true)
    public void test_newcontact_Tests_file() {

        app.contact().checkContact(); //зайти на страницу контактов

        //   Contacts before = app.contact().contact_all();  //работа со множествами сначала
        File photo = new File("src/test/resources/8marta.png");

        NewContactData1 contact = new NewContactData1()
                .withLast_name("Testovich5").withFirst_name("Test").withMiddle_name("Testyi")
                .withNick_name("Testik").withCompany_name("Test_High_Technologies")
                .withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com")
                .withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780")
                .withGroup("Yuri1_test_group")
                .withPhoto(photo); //заполнить фотографию

        app.contact().create_contact(contact);
        //  Contacts after = app.contact().contact_all(); //список контактов после изменения

        //     assertThat(after.size(), equalTo(before.size() + 1)); //проверка данных по количеству контактов


        //          before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt())))); //проверка множеств через Hamcrest проверка множеств контактов

    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath()); //отображение пути к рабочей папке программы
        File photo = new File("src/test/resources/8marta.png");
        System.out.println(photo.getAbsolutePath());
    }
}
