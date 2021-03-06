package ru.stqa.yuri.addressbook1.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

//тест удаление группы
public class yuriDeleteGroupTest1 extends TestBase {

    @BeforeMethod(enabled = true)
    public void testPreconditions() {
        app.goTo().groupPage();
        if (app.db().groups().size()== 0) { //проверка на то что групп на странице нет
            app.group().create(new GroupData1().withNameGroup("Yuri1_test_group")); // если нет то создаём
        }
    }


    @Test(enabled = true)
    public void yuriDeletionGroupTest1() {

        Groups before = app.db().groups();
        GroupData1 deletedGroup = before.iterator().next();


        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() -1));
        Groups after = app.db().groups();
    //    assertEquals(after.size(), before.size() - 1);  // должно убавиться на -1 группу
        assertThat(after, equalTo(before.without(deletedGroup)));

    }


}
