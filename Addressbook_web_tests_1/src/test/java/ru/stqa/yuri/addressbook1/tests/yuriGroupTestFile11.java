package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bilovyur on 19.03.2017.
 */
//создание групп, параметризированные тесты
    
public class yuriGroupTestFile11 extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData1().withNameGroup("test1").withHeaderGroup("header 1").withNameFooter("footer 1")}); //массив из одного объекта типа GroupData1
        list.add(new Object[]{new GroupData1().withNameGroup("test2").withHeaderGroup("header 2").withNameFooter("footer 2")});
        list.add(new Object[]{new GroupData1().withNameGroup("test3").withHeaderGroup("header 3").withNameFooter("footer 3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups",enabled = true) //цикл устраивает фреймворк TestNG
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
