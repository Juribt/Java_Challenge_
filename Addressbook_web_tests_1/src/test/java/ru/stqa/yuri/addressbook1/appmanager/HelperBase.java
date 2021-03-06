package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by bilovyur on 31.01.2017.
 */
public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) { //если null ничего не делаем
        String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)){
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
                   }
          }

    protected void attach(By locator, File file) { //ввод данных по директорию

        if (file != null) { //если null ничего не делаем
            wd.findElement(locator).sendKeys(file.getAbsolutePath()); // ввод значения директория

        }
    }



    public  boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) { //ищем локатор
        try {
            wd.findElement(locator);
            return true; //если элемент нашёлся
        } catch(NoSuchElementException ex) {return false;} // если элемент не найден возращаем false

    }
}
