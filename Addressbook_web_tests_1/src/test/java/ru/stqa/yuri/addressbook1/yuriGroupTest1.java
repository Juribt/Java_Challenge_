package ru.stqa.yuri.addressbook1;

import org.testng.annotations.Test;

//тест создание новой группы

/**
 * Created by bilovyur on 25.01.2017.
 */
public class yuriGroupTest1 extends TestBase {


        @Test
        public void test_group_Tests1() {
            openGroupPage();
            createNewGroup();
            fillGroupForm(new GroupData1("Yuri1_test_group", "Header_group", "Yuri_group"));
            openGroupPage(); //зайти на страницу Группы
        }

    }




