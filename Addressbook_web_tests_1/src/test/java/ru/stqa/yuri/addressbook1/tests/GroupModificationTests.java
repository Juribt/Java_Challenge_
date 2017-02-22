package ru.stqa.yuri.addressbook1.tests;

//import org.omg.CORBA.Object;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

import java.util.Comparator;
import java.util.List;



/**
 * Created by bilovyur on 01.02.2017.
 */
//тест на изменение группы
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void testPreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0) { //проверка на то что групп на странице нет
            app.group().create(new GroupData1("Yuri1_test_group", null, null)); // если нет то создаём
        }
    }


    @Test
    public void testGroupModification() {


        List<GroupData1> before = app.group().list();
        int index = before.size() - 1; //оптимизация переменной
        GroupData1 group = new GroupData1(before.get(index).getId(),"Yuri1_test_group", "Header1_group", "Yuri3_group");
        app.group().modify(index, group);// модификация группы

        List<GroupData1> after = app.group().list();
        Assert.assertEquals(after.size(), before.size()); // количество групп не изменилось
        before.remove(index); //удалить первоначальное значение группы
        before.add(group); //добавить последнее изменённое значение
        Comparator<? super GroupData1> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}


