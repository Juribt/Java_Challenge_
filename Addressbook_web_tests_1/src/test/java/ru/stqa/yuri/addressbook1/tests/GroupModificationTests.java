package ru.stqa.yuri.addressbook1.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


/**
 * Created by bilovyur on 01.02.2017.
 */
//тест на изменение группы
public class GroupModificationTests extends TestBase {

    @BeforeMethod(enabled = true)
    public void testPreconditions(){
        if (app.db().groups().size()== 0){
            app.goTo().groupPage();
            app.group().create(new GroupData1().withNameGroup("Yuri1_test_group")); // если нет то создаём
        }

      //  app.goTo().groupPage();
    //    if (app.group().all().size() == 0) { //проверка на то что групп на странице нет
     //       app.group().create(new GroupData1().withNameGroup("Yuri1_test_group")); // если нет то создаём
     //   }
    }


    @Test(enabled = true)
    public void testGroupModification() {


    //    Groups before = app.group().all();
        Groups before = app.db().groups(); //получаем данные из базы напрямую
        GroupData1 modifiedGroup = before.iterator().next();

        GroupData1 group = new GroupData1().withId(modifiedGroup.getId()).withNameGroup("Yuri1_test_group").withHeaderGroup("Header1_group").withNameFooter("Yuri3_group");
        app.goTo().groupPage();
        app.group().modify(group);// модификация группы

        assertThat(app.group().count(), equalTo(before.size())); //сравнивать количество
     //   Groups after = app.group().all();
        Groups after = app.db().groups();//получаем данные из базы напрямую
    //   assertEquals(after.size(), before.size()); // количество групп не изменилось
       assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }

}


