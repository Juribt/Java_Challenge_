package ru.stqa.yuri.addressbook1.tests;

//import org.omg.CORBA.Object;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by bilovyur on 01.02.2017.
 */
//тест на изменение группы
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().openGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) { //проверка на то что групп на странице нет
            app.getGroupHelper().createGroup(new GroupData1("Yuri1_test_group", null, null)); // если нет то создаём
        }

        List<GroupData1> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData1 group = new GroupData1(before.get(before.size() - 1).getId(),"Yuri1_test_group", "Header1_group", "Yuri3_group");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().openGroupPage();

        List<GroupData1> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()); // количество групп не изменилось
        before.remove(before.size() - 1); //удалить первоначальное значение группы
        before.add(group); //добавить последнее изменённое значение
        Comparator<? super GroupData1> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}


