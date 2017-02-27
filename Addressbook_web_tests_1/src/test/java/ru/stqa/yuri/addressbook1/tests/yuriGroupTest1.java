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
        assertThat(app.group().count(), equalTo(before.size() + 1));//проверка ставится перед after для увеличения скорости проверки
        Groups after = app.group().all();


        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt())))); //проверка множеств через Hamcrest
    }

    @Test(enabled = true)
    public void test_bad_creation_Test() {
        app.goTo().groupPage();
        Groups before = app.group().all();  //работа со множествами
        GroupData1 group = new GroupData1().withNameGroup("Yuri1_test_group1'"); //из-за апострофа группа не создаётся, поэтому тест не падает

        app.group().create(group);
        app.goTo().groupPage(); //зайти на страницу Группы

        assertThat(app.group().count(), equalTo(before.size()));//если кол-во групп не сходится то упадёт быстрее, чем при анализе списков
        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size()));//размер не должен поменяться


        assertThat(after, equalTo(before)); //старый список должен быть равен новому списку
    }

}




