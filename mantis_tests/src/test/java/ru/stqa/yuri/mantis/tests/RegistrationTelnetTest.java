package ru.stqa.yuri.mantis.tests;

import model.MailMessage;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by bilovyur on 28.04.2017.
 */
public class RegistrationTelnetTest extends TestBase{

    @Test
    public void testTelnetRegistration()throws IOException, MessagingException, InterruptedException{

        long now= System.currentTimeMillis();
        String email = String.format("user%s@localhost.localdomain", now);
        String user1 = "user" +now;
        String password = "password";
        app.james().createUser(user1, password);//создание юзера на сервере
        app.registration().start(user1, email); //данные юзера и его email

     //   List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        List<MailMessage> mailMessages = app.james().waitForMail(user1, password,120000);

        String confirmationLink =  findConfirmationLink(mailMessages,email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user1, password)); //заходим в систему под юзеором
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage= mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text); //возвращаем полученное значение, т.е ссылку
    }


}
