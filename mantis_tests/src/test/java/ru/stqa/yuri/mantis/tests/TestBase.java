package ru.stqa.yuri.mantis.tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;






/**
 * Created by bilovyur on 25.01.2017.
 */
public class TestBase {



    public static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\windows\\system32\\chromedriver.exe");
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
