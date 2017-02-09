package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by bilovyur on 31.01.2017.
 */
public class SessionHelper extends HelperBase {
  //  private FirefoxDriver wd;

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
       type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }


}
