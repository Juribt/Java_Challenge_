package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

//тест удаление группы
public class yuriDeleteGroupTest1 extends TestBase {

    @Test
    public void yuriDeletionGroupTest1() {
        app.getNavigationHelper().openGroupPage();
        if (!app.getGroupHelper().isThereAGroup()){ //проверка на то что групп на странице нет
            app.getGroupHelper().createGroup(new GroupData1("Yuri1_test_group", null, null)); // если нет то создаём
        }

        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().openGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before-1);  // должно убавиться на -1 группу
    }


}
