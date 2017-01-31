package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

/**
 * Created by bilovyur on 31.01.2017.
 */
public class ContactHelper extends HelperBase {
//private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void checkNewContact() { //посмотреть что контакт создался
        click(By.linkText("home"));
    }

    public void fillNewContactForm(NewContactData1 newContactData) { //заполнение формы нового контакта
        type(By.name("lastname"),newContactData.getLast_name());
        type(By.name("firstname"),newContactData.getFirst_name());
        type(By.name("middlename"),newContactData.getMiddle_name());
        type(By.name("nickname"),newContactData.getNick_name());
        type(By.name("company"),newContactData.getCompany_name());
        type(By.name("mobile"),newContactData.getMobile_phone());
        type(By.name("email"),newContactData.getEmail_1());
        type(By.name("address"),newContactData.getAddress());
        type(By.name("home"),newContactData.getHome_phone());
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }
}
