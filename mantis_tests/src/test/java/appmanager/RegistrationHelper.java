package appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by bilovyur on 21.04.2017.
 */
public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver(); //метод запрашивает драйвер в момент первого обращения
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php"); //ссылка на страницу регистрации    }
    }
}