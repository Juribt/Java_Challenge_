package ru.stqa.yuri.addressbook1.tests;


import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


//тест создание новой группы

/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriGroupTest1 extends TestBase {


    @Test(enabled = true)
    public void test_group_Tests1() {
        app.goTo().groupPage();
        Groups before = app.group().all();  //работа со множествами
        GroupData1 group = new GroupData1().withNameGroup("Yuri1_test_group");

        app.group().create(group);
        app.goTo().groupPage(); //зайти на страницу Группы
        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size() + 1));


        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt())))); //проверка множеств через Hamcrest
    }

}




