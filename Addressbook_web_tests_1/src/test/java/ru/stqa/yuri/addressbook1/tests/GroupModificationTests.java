package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
/**
 * Created by bilovyur on 01.02.2017.
 */
//тест на изменение группы
public class GroupModificationTests extends TestBase {

 @Test
    public void testGroupModification ()
 {
     app.getNavigationHelper().openGroupPage();
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData1("Yuri1_test_group", "Header1_group", "Yuri3_group"));
     app.getGroupHelper().submitGroupModification();
     app.getNavigationHelper().openGroupPage();
 }

}


