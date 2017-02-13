package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.yuri.addressbook1.model.GroupData1;

/**
 * Created by bilovyur on 30.01.2017.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void createNewGroup() {
        click(By.name("new"));
    }//создать новую группу

    public void fillGroupForm(GroupData1 groupData) {
        type(By.name("group_name"), groupData.getNameGroup());
        type(By.name("group_header"), groupData.getHeaderGroup());
        type(By.name("group_footer"), groupData.getNameFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void openGroupPage_test() { //проверка нескольких сочетаний того, что страница Группы уже открыта
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void createGroup(GroupData1 group) {
        createNewGroup();
        fillGroupForm(group);
        submitGroupCreation();
        openGroupPage_test();//
            }

    public boolean isThereAGroup() {      //есть ли группа на странице Групп
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
       return  wd.findElements(By.name("selected[]")).size(); //возвращает количество элементов на странице
       // return 0;
    }
}
