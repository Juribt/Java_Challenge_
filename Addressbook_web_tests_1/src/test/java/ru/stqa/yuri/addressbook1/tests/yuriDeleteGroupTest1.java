package ru.stqa.yuri.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import java.util.Set;

//тест удаление группы
public class yuriDeleteGroupTest1 extends TestBase {

    @BeforeMethod
    public void testPreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) { //проверка на то что групп на странице нет
            app.group().create(new GroupData1().withNameGroup("Yuri1_test_group")); // если нет то создаём
        }
    }


    @Test
    public void yuriDeletionGroupTest1() {

        Set<GroupData1> before = app.group().all();
        GroupData1 deletedGroup = before.iterator().next();


        app.group().delete(deletedGroup);

        Set<GroupData1> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);  // должно убавиться на -1 группу

        before.remove(deletedGroup); //в before должны быть такой же список как и в after

        Assert.assertEquals(before, after); //можно сравнивать списки и без цикла

    }


}
