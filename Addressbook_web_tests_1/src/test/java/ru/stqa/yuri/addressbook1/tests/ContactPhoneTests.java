package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.NewContactData2;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 04.03.2017.
 */
public class ContactPhoneTests extends TestBase {
    @BeforeMethod(enabled = true)
    public void testContactPreconditions() {  //проверка предусловий контактов
        app.goTo().checkNewContact(); //открыть страницу контактов
        if (app.contact().contact_inf_temp().size() == 0) { //проверка на то что контактов на странице нет
            app.contact().create_contact1(new NewContactData2()
                    .withLast_name("Testovich").withFirst_name("Test").withMiddle_name("Testyi").withNick_name("Testik").withCompany_name("Test_High_Technologies").withMobile_phone("89526656583").withEmail_1("john_swift@yahoo.com").withAddress("England, Solsbery, Flint str, h 7, fl. 8").withHome_phone("6402780"));
                    }

    }

    @Test
    public void test_newcontact_Tests() {

        NewContactData2 contact = app.contact().contact_inf_temp().iterator().next(); //загрузка множества контактов

        NewContactData2 contactInfoFromEditForm = app.contact().infoFromEditForm1(contact); // загрузка информации о контакте из формы редактирования, выбираем случайный контакт

        assertThat(cleaned_1(contact.getAddress()), equalTo(mergeAddress(contactInfoFromEditForm))); //проверка без пробелов
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    }

    private String mergeEmails(NewContactData2 contact) { //склеиваем и анализируем строки емэйлов
        return   Arrays.asList(contact.getEmail_1(), contact.getEmail_2(),
                contact.getEmail_3()).stream().filter((s) -> ! s.equals(""))
                               .collect(Collectors.joining("\n"));
    }

    private String mergePhones(NewContactData2 contact) { //склеиваем и анализируем строки телефонов
    return   Arrays.asList(contact.getHome_phone(), contact.getMobile_phone(),
                contact.getWork_phone(), contact.getHome_phone_1()).stream().filter((s) -> ! s.equals(""))
        .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
       }

    private String mergeAddress(NewContactData2 contact) { //склеиваем и анализируем строки телефонов
        return   Arrays.asList(contact.getAddress()).stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned_1)
                .collect(Collectors.joining("\n"));
        
    }

    public static String cleaned(String phone) {  //чистим ненужные символы
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public static String cleaned_1(String phone) {  //чистим ненужные символы
        return phone.replaceAll("\\s", "");
    }
}