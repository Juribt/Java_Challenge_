package ru.stqa.yuri.mantis.tests;

import model.MailMessage;
import model.Users;
import model.UsersData1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by bilovyur on 26.04.2017.
 */
public class ChangeUserPassword extends TestBase {

    @BeforeMethod
    public void startMailServer_1() throws InterruptedException, IOException, MessagingException {
        app.mail().start(); //запуск Mail Server перед тестом
        if (app.db().users().size() == 0) { //создаём юзера, если его нет
            long now1 = System.currentTimeMillis();
            String email = String.format("user%s@localhost.localdomain", now1);
            String user1 = "user" + now1;
            String password = "password";
            app.registration().start(user1, email); //данные юзера и его email
            List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
            String confirmationLink = app.registration().findConfirmationLink(mailMessages, email);
            app.registration().finish(confirmationLink, password);
        }
    }

    @Test
    public void changeUserPassword() throws InterruptedException, IOException, MessagingException {
        // получаем данные юзера
        String user_id;
        String user_email;
        Users get_user = app.db().users();
        UsersData1 user_data = get_user.iterator().next();
        user_id = user_data.getNameUser();
        user_email = user_data.getEmailUser();
       // активность администратора
        app.registration().admin_session("administrator", "root"); //заходим администратором
        app.registration().get_user(user_id); //сбрасываем пароль юзеру
        // получение и анализ письма
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink =  app.registration().findConfirmationLink(mailMessages,user_email);
        long now= System.currentTimeMillis();
        String password = "password_" + now ;
        app.registration().finish(confirmationLink, password); //меняем пароль для юзера
        assertTrue(app.newSession().login(user_id, password)); //проверяем, что можем зайти
    }

    @AfterMethod(alwaysRun = true) //если с ошибкой завершился всё равно останавливать
    public void stopMailServer_1() {

        app.mail().stop(); //запуск Mail Server перед тестом
    }

}
