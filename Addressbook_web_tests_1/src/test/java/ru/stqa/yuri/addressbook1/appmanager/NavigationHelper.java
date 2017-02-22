package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by bilovyur on 30.01.2017.
 */
public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() { //проверка нескольких сочетаний того, что страница Группы уже открыта
        if(isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
                click(By.linkText("groups"));
    } //открыть группу

    public void checkNewContact() { //посмотреть что контакт создался
        if (isElementPresent(By.id("maintable"))){     //если мы уже на странице то никуда не переходить
            return;
        }
        click(By.linkText("home"));
    }
}
