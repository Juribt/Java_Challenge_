package ru.stqa.yuri.addressbook1.tests;

//import org.omg.CORBA.Object;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import java.util.Set;


/**
 * Created by bilovyur on 01.02.2017.
 */
//тест на изменение группы
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void testPreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) { //проверка на то что групп на странице нет
            app.group().create(new GroupData1().withNameGroup("Yuri1_test_group")); // если нет то создаём
        }
    }


    @Test
    public void testGroupModification() {


        Set<GroupData1> before = app.group().all();
        GroupData1 modifiedGroup = before.iterator().next();

        GroupData1 group = new GroupData1().withId(modifiedGroup.getId()).withNameGroup("Yuri1_test_group").withHeaderGroup("Header1_group").withNameFooter("Yuri3_group");
        app.group().modify(group);// модификация группы

        Set<GroupData1> after = app.group().all();
        Assert.assertEquals(after.size(), before.size()); // количество групп не изменилось

        before.remove(modifiedGroup); //удалить первоначальное значение группы
        before.add(group); //добавить последнее изменённое значение

        Assert.assertEquals(before, after);
    }

}


