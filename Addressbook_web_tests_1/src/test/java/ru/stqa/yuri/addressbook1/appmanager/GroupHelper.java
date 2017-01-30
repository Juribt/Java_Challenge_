package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.yuri.addressbook1.model.GroupData1;

/**
 * Created by bilovyur on 30.01.2017.
 */
public class GroupHelper {
private FirefoxDriver wd;

    public GroupHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

     public void createNewGroup() {
        wd.findElement(By.name("new")).click();
    }//создать новую группу

    public void fillGroupForm(GroupData1 groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getNameGroup());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeaderGroup());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getNameFooter());
        wd.findElement(By.name("submit")).click();
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}
