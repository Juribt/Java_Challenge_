package ru.stqa.yuri.addressbook1.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.yuri.addressbook1.appmanager.ApplicationManager;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class TestBase {

    public final ApplicationManager app = new ApplicationManager(BrowserType.IE);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
