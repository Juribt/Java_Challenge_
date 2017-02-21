package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

//тест создание новой группы

/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriGroupTest1 extends TestBase {


    @Test(enabled = false)
    public void test_group_Tests1() {
        app.getNavigationHelper().openGroupPage();
        List<GroupData1> before = app.getGroupHelper().getGroupList();
        GroupData1 group = new GroupData1("Yuri1_test_group", null, null);

        app.getGroupHelper().createGroup(group);
        app.getNavigationHelper().openGroupPage(); //зайти на страницу Группы
        List<GroupData1> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(group);
        Comparator<? super GroupData1> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after); //сравнение списков
    }

}




