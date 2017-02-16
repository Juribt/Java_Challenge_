package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.yuri.addressbook1.model.GroupData1;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click(); //выбираем элемент по индексу и кликаем его
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
        return wd.findElements(By.name("selected[]")).size(); //возвращает количество элементов на странице
        // return 0;
    }

    public List<GroupData1> getGroupList() {
        List<GroupData1> groups = new ArrayList<GroupData1>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements) {
            String name= element.getText(); //получаем текст с элемента на странице
            int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); //получаем идентификатор группы
                    GroupData1 group = new GroupData1(id, name, null,null); //получить объект группы
            groups.add(group); //Добавить созданный объект в список
        }
        return groups; //возвращение списка
    }
}
