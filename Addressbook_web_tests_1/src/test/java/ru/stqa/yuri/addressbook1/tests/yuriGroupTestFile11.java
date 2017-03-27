package ru.stqa.yuri.addressbook1.tests;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 19.03.2017.
 */
//создание групп, параметризированные тесты

public class yuriGroupTestFile11 extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromXML() throws IOException {

      try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))){
          String xml="";
          String line = reader.readLine(); // считывание по строке
          while (line != null) {  // читаем данные строка за строкой
              xml += line;
              //        String[] split = line.split(":");
              //      list.add(new Object[]{new GroupData1().withNameGroup(split[0]).withHeaderGroup(split[1]).withNameFooter(split[2])}); //получаем данные по группе из файла
              line = reader.readLine(); //считаем следующую строку
          }
          XStream xstream = new XStream();
          xstream.processAnnotations(GroupData1.class); //указать процесс обработки аннотаций
          List<GroupData1> groups = (List<GroupData1>) xstream.fromXML(xml); //преобразование данных из xml
          return groups.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator(); //выдаём данные

      } //Reader не надо закрывать он сам закроется


    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {

        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))){
            String json="";
            String line = reader.readLine(); // считывание по строке
            while (line != null) {  // читаем данные строка за строкой
                json += line;
                line = reader.readLine(); //считаем следующую строку
            }
            Gson gson = new Gson();
            List<GroupData1> groups =   gson.fromJson(json,new TypeToken<List<GroupData1>>(){}.getType());//List<GroupData1>.class - десериализация объекта


            return groups.stream().map((g) -> new Object [] {g}).collect(Collectors.toList()).iterator();
        } //Reader не надо закрывать он сам закроется


    }


    @Test(dataProvider = "validGroupsFromXML") //цикл устраивает фреймворк TestNG
    public void test_group_Tests_file1(GroupData1 group) {

        //   GroupData1 group = new GroupData1().withNameGroup(name).withHeaderGroup(header).withNameFooter(footer);
        app.goTo().groupPage();
        Groups before = app.group().all();  //работа со множествами
        app.group().create(group);
        app.goTo().groupPage(); //зайти на страницу Группы
        assertThat(app.group().count(), equalTo(before.size() + 1));//проверка ставится перед after для увеличения скорости проверки
        Groups after = app.group().all();


        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); //проверка множеств через Hamcrest

        ;


    }


}
