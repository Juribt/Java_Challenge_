package ru.stqa.yuri.mantis.tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;


/**
 * Created by bilovyur on 25.01.2017.
 */
public class TestBase {



    public static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {

        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak","config_inc.php");
        app.stop();
    }

    public static void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public static boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
             return app.soap().getIssue(issueId);
    }
}
