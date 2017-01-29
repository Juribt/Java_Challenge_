package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;
//тест удаление группы
public class yuriDeleteGroupTest1 extends TestBase {

    @Test
    public void yuriDeletionGroupTest1() {
        app.openGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.openGroupPage();
    }


}
