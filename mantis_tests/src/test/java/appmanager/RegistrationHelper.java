package appmanager;

import org.openqa.selenium.By;


/**
 * Created by bilovyur on 21.04.2017.
 */
public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
       super(app);

    }

    public void start(String username, String email) throws InterruptedException {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php"); //ссылка на страницу регистрации    }
        type(By.name("username"), username); //вводим данные юзера
        type(By.name("email"), email); //вводим данные email
            click(By.cssSelector("input[value='Signup']")); //нажать на кнопку Signup для регистрации
    }

    public void finish(String confirmationLink, String password) throws InterruptedException {
        wd.get(confirmationLink); //проходим по ссылке
        type(By.name("password"), password);
        type(By.name("password_confirm"), password); // подтверждение пароля
        wd.findElement(By.className("bigger-110")).click();
    }
}