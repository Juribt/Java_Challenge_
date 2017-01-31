package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by bilovyur on 30.01.2017.
 */
public class NavigationHelper extends HelperBase {
//private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void openGroupPage() {
        click(By.linkText("groups"));
    } //открыть группу
}
