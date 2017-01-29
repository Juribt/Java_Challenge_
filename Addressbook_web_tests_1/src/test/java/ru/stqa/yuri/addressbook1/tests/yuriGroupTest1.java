package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;

//тест создание новой группы

/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriGroupTest1 extends TestBase {


        @Test
        public void test_group_Tests1() {
            app.openGroupPage();
            app.createNewGroup();
            app.fillGroupForm(new GroupData1("Yuri1_test_group", "Header_group", "Yuri_group"));
            app.openGroupPage(); //зайти на страницу Группы
        }

    }




