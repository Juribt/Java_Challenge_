package ru.stqa.yuri.addressbook1.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.yuri.addressbook1.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Created by bilovyur on 25.01.2017.
 */
public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

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

    @BeforeMethod
    public void logTestStart (Method m, Object[] p){ //Object[] - будет содержать параметры тестового метода
        logger.info("Start test " + m.getName()+ " with parameters " + Arrays.asList(p)); //где m.getName() - имя теста, который был запущен
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop (Method m){
        logger.info("Stop test " + m.getName()); //где m.getName() - имя теста, который был завершён
    }

}
