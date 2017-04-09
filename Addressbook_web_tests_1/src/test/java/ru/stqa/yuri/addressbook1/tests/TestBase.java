package ru.stqa.yuri.addressbook1.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.yuri.addressbook1.appmanager.ApplicationManager;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


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
    public void logTestStart(Method m, Object[] p) { //Object[] - будет содержать параметры тестового метода
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p)); //где m.getName() - имя теста, который был запущен
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName()); //где m.getName() - имя теста, который был завершён
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {

        Groups dbGroups = app.db().groups();
        Groups uiGroups = app.group().all();
        assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData1()
                .withId(g.getId()).withNameGroup(g.getNameGroup()))
                .collect(Collectors.toSet()))); //сравнивать только id и имя группы между данными из БД и UI
    }

}
}
