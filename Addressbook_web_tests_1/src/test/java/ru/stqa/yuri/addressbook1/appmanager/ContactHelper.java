package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

/**
 * Created by bilovyur on 31.01.2017.
 */
public class ContactHelper {
private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void checkNewContact() { //посмотреть что контакт создался
        wd.findElement(By.linkText("home")).click();
    }

    public void fillNewContactForm(NewContactData1 newContactData) { //заполнение формы нового контакта
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(newContactData.getLast_name());
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(newContactData.getFirst_name());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(newContactData.getMiddle_name());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(newContactData.getNick_name());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(newContactData.getCompany_name());
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(newContactData.getMobile_phone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(newContactData.getEmail_1());
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(newContactData.getAddress());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(newContactData.getHome_phone());
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void createNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }
}
