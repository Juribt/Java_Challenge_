package appmanager;

import model.MailMessage;
import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;

import java.util.List;


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


    public void admin_session(String username, String password) throws InterruptedException {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php"); //ссылка на страницу регистрации    }
        type(By.name("username"), username); //вводим данные юзера
        type(By.name("password"), password); //вводим данные email
        click(By.cssSelector("input[value='Login']")); //нажать на кнопку Signup для регистрации
    }

    public void get_user(String user_id){

        wd.findElement(By.linkText("Manage")).click();
        wd.findElement(By.linkText("Manage Users")).click();
        wd.findElement(By.linkText(user_id)).click(); //находим user -а
      click(By.cssSelector("input[value='Reset Password']")); // Reset Password
        //
    }

    public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage= mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text); //возвращаем полученное значение, т.е ссылку
    }
}