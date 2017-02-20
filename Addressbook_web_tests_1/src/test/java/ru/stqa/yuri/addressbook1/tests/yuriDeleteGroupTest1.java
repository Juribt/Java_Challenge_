package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

import java.util.List;

//тест удаление группы
public class yuriDeleteGroupTest1 extends TestBase {

    @BeforeMethod
    public void testPreconditions(){
        app.getNavigationHelper().openGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) { //проверка на то что групп на странице нет
            app.getGroupHelper().createGroup(new GroupData1("Yuri1_test_group", null, null)); // если нет то создаём
        }
    }


    @Test
    public void yuriDeletionGroupTest1() {

        List<GroupData1> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().openGroupPage();

        List<GroupData1> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);  // должно убавиться на -1 группу

        before.remove(before.size() - 1); //в before должны быть такой же список как и в after

        Assert.assertEquals(before, after); //можно сравнивать списки и без цикла

    }


}
