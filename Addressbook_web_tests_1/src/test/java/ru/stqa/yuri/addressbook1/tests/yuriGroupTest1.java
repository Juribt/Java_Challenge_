package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import java.util.Set;

//тест создание новой группы

/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriGroupTest1 extends TestBase {


    @Test(enabled = true)
    public void test_group_Tests1() {
        app.goTo().groupPage();
        Set<GroupData1> before = app.group().all();  //работа со множествами
        GroupData1 group = new GroupData1().withNameGroup("Yuri1_test_group");

        app.group().create(group);
        app.goTo().groupPage(); //зайти на страницу Группы
        Set<GroupData1> after = app.group().all();

        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()); //объекты преобразуются в числа
        before.add(group);

        Assert.assertEquals(before, after); //сравнение списков
    }

}




