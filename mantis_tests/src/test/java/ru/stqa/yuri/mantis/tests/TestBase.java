package ru.stqa.yuri.mantis.tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


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
        app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak","config_inc.php");
        app.stop();
    }


}
