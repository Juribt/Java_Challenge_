package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

//тест создание новой группы

/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriGroupTest1 extends TestBase {


    @Test
    public void test_group_Tests1() {
        app.getNavigationHelper().openGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData1("Yuri1_test_group", null, null));
        app.getNavigationHelper().openGroupPage(); //зайти на страницу Группы
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before+1);
    }

}




