package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.yuri.addressbook1.model.GroupData1;

/**
 * Created by bilovyur on 30.01.2017.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

     public void createNewGroup() {
         click(By.name("new"));
     }//создать новую группу

    public void fillGroupForm(GroupData1 groupData) {
        type(By.name("group_name"), groupData.getNameGroup());
        type(By.name("group_header"), groupData.getHeaderGroup());
        type(By.name("group_footer"), groupData.getNameFooter());
        submitGroupCreation();
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
}
