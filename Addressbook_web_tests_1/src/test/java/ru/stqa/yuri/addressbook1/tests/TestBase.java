package ru.stqa.yuri.addressbook1.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.yuri.addressbook1.appmanager.ApplicationManager;

import java.io.File;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class TestBase {

         public final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "C:\\windows\\system32\\chromedriver.exe");
              app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
