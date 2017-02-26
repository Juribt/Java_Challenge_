package ru.stqa.yuri.addressbook1.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.yuri.addressbook1.appmanager.ApplicationManager;



/**
 * Created by bilovyur on 25.01.2017.
 */
public class TestBase {

         public static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "C:\\windows\\system32\\chromedriver.exe");
              app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
