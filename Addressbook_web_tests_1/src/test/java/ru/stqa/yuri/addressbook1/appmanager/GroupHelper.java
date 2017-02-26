package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); //выбираем элемент по id и кликаем его
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void open_page() { //проверка нескольких сочетаний того, что страница Группы уже открыта
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void create(GroupData1 group) {
        createNewGroup();
        fillGroupForm(group);
        submitGroupCreation();
        open_page();//
    }

    public void modify(GroupData1 group) { //оптимизация модификации группы
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        open_page();
    }

    public boolean isThereAGroup() {      //есть ли группа на странице Групп
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size(); //возвращает количество элементов на странице
    }



    public Set<GroupData1> all() { //вспомогательный метод возвращающий множество
        Set<GroupData1> groups = new HashSet<GroupData1>();

        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText(); //получаем текст с элемента на странице
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); //получаем идентификатор группы

            groups.add(new GroupData1().withId(id).withNameGroup(name)); //Добавить созданный объект в список c ууказанным идентификатором и указанным именем
        }
        return groups; //возвращение списка
    }


    public void delete(GroupData1 group) {
        selectGroupById(group.getId());  //выбрать элемент для удаления по id
        deleteSelectedGroups();
        open_page();
    }
}
