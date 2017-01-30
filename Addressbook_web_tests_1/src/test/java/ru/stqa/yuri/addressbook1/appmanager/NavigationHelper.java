package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by bilovyur on 30.01.2017.
 */
public class NavigationHelper {
private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void openGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    } //открыть группу
}
