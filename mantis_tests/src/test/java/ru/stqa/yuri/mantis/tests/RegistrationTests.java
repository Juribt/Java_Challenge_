package ru.stqa.yuri.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by bilovyur on 21.04.2017.
 */
public class RegistrationTests extends TestBase{

    @Test
    public void testRegistration(){
       app.registration().start("user1","user1@localhost.localdomain"); //данные юзера и его email

    }
}
