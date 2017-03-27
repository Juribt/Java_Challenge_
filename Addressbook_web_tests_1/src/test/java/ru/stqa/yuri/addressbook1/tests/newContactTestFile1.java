package ru.stqa.yuri.addressbook1.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 09.03.2017.
 */
public class newContactTestFile1 extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml"))); //может возникать исключение
        String xml="";
        String line = reader.readLine(); // считывание по строке
        while (line != null) {  // читаем данные строка за строкой
            xml += line;   //считываем данные по контактам

            line = reader.readLine(); //считаем следующую строку
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(NewContactData1.class); //указать процесс обработки аннотаций
        List<NewContactData1> contacts = (List<NewContactData1>) xstream.fromXML(xml); //преобразование данных из xml
        return contacts.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator(); //выдаём данные

    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json"))); //может возникать исключение
        String json="";
        String line = reader.readLine(); // считывание по строке
        while (line != null) {  // читаем данные строка за строкой
            json += line;
            line = reader.readLine(); //считаем следующую строку
        }
        Gson gson = new Gson();
        List<NewContactData1> contacts =   gson.fromJson(json,new TypeToken<List<NewContactData1>>(){}.getType());//List<GroupData1>.class - десериализация объекта


        return contacts.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator(); //выдаём данные, заворачиваем объект в массив

    }


    @Test(dataProvider = "validContactsFromXML") //цикл устраивает фреймворк TestNG
    public void test_contact_Tests_file1(NewContactData1 contact) {

        app.contact().checkContact();
        Contacts before = app.contact().contact_all();  //работа со множествами

        app.contact().create_contact_file(contact); //создание контакта



       Contacts after = app.contact().contact_all(); //список контактов после

     assertThat(after.size(), equalTo(before.size() + 1));

      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); //проверка множеств через Hamcrest

        ;


    }






}
