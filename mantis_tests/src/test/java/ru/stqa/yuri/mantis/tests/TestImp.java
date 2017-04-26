package ru.stqa.yuri.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by bilovyur on 26.04.2017.
 */
public class TestImp extends TestBase {
    @Test
    public void closeServer (){
        app.mail().stop();
    }
}
