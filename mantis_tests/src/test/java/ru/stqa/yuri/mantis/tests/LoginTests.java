package ru.stqa.yuri.mantis.tests;

import appmanager.HttpSession;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by bilovyur on 21.04.2017.
 */
public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
       HttpSession session = app.newSession();

    assertTrue(session.login("administrator","root"));//проверим, что в итоге мы зашли на страницу
       assertTrue(session.isLoggedInAs("administrator"));// и я администратор

    }

}
