package ru.stqa.yuri.addressbook1;

import org.testng.annotations.Test;
//тест удаление группы
public class yuriDeleteGroupTest1 extends TestBase {

    @Test
    public void yuriDeletionGroupTest1() {
        openGroupPage();
        selectGroup();
        deleteSelectedGroups();
        openGroupPage();
    }


}
