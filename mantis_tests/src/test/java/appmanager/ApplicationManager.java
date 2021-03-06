package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by bilovyur on 29.01.2017.
 */
public class ApplicationManager {
    private final Properties properties;
 private WebDriver wd; //сделаем так чтобы обращение было только через getDriver()


    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;
    private DbHelper dbHelper;
    private JamesHelper jamesHelper;
    private SoapHelper soapHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;


        properties = new Properties();

    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local"); //часть имени конфигурационного файла
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DbHelper(); //инициализация помощника по работе с базой данных
    }


    public void stop() { //останавливаем, если драйвер проинициализирован
        if (wd!=null){
            wd.quit();
        }

    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public FtpHelper ftp() {
      if (ftp==null){
          ftp = new FtpHelper(this);
      }
       return ftp;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null){
            registrationHelper = new RegistrationHelper(this);
        }
       return registrationHelper;
    }

    public WebDriver getDriver() {
        if (wd == null) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }

            wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            wd.manage().window().maximize(); //раскрыть окно
            wd.get(properties.getProperty("web.baseUrl"));//"http://localhost:8081/addressbook");

        }
        return wd; //driver
    }

    public MailHelper mail(){
        if (mailHelper == null){
            mailHelper= new MailHelper(this);
        }
        return mailHelper;
    }
    public DbHelper db(){return dbHelper;}

    public JamesHelper james(){
        if (jamesHelper == null){
            jamesHelper = new JamesHelper(this);
        }
        return jamesHelper;
    }
    public SoapHelper soap(){
        if (soapHelper == null){
            soapHelper = new SoapHelper(this);
        }
        return soapHelper;
    }
}
