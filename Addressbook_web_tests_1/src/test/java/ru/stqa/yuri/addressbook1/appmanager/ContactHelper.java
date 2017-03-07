package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.util.List;


/**
 * Created by bilovyur on 31.01.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void fillNewContactForm(NewContactData1 newContactData, boolean creation) { //заполнение формы нового контакта
        type(By.name("lastname"), newContactData.getLast_name());
        type(By.name("firstname"), newContactData.getFirst_name());
        type(By.name("middlename"), newContactData.getMiddle_name());
        type(By.name("nickname"), newContactData.getNick_name());
        type(By.name("company"), newContactData.getCompany_name());
        type(By.name("mobile"), newContactData.getMobile_phone());
        type(By.name("email"), newContactData.getEmail_1());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHome_phone());

        if (creation) {   //если форма создания то выпадающий список должен быть, если нет то выполнение упадёт
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
        } else {        // мы пришли на форму модификации контакта
            Assert.assertFalse(isElementPresent(By.name("new_group"))); //проверка того что на странице модификации контакта не должна находится кнопка группы

        }

        if (isElementPresent(By.name("new_group"))) {                  //если элемент есть тогда используем его, еслиего нет то неисспользуем
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
        }

    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }


    public void changeContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); //выбираем элемент по индексу и кликаем его
    }

    public void modifyById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        wd.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();

    }

    public void getContactwithoutCheckBoxById(int id) {
    /* 1)  WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id))); //определение checkbox
        WebElement row = checkbox.findElement(By.xpath("./../..")); //поднимаемся от элемента на 2 уровня вверх, нашли строку
        List<WebElement> cells = row.findElements(By.tagName("td")); //получаем все ячейки в строке
        cells.get(7).findElement(By.tagName("a")).click(); // среди ячеек берём нужную 8-й столбец, находим там тэг ссылки, после этого кликаем
         */
   //  2)   wd.findElement(By.xpath(String.format("input[value='%s']/../../td[8]/a", id))).click();
       //     wd.findElement(By.xpath(String.format("//tr[.//input[value='%s']]/td[8]/a", id))).click();
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    //       wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    //       wd.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();

    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]")); //submit updated contact
    }

    public void deleteContact() {  // удаление контакта - 1-й вариант
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void makeSelectedContact() {  // удаление контакта - 2-й вариант
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[1]/input[1]"));
    }

    public void deleteContact_1() {  // удаление контакта - 2-й вариант
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept(); //make accepted
    }

    public boolean isThereAContact() {      //есть ли есть какой-нибудь контакт на странице Контактов
        return isElementPresent(By.name("selected[]"));
    }

    public void create_contact(NewContactData1 contact) { //создание контакта
        createNewContact();
        fillNewContactForm(contact, true);
        submitNewContact();
        checkContact();
    }

    public void modifyContact(NewContactData1 contact) { //изменение контакта
        modifyById(contact.getId());
        fillNewContactForm(contact, false);
        updateContact(); //submit updated contact
        checkContact(); // зайти на страницу для проверки
    }

    public void checkContact() { //посмотреть что контакт создался
        if (isElementPresent(By.id("maintable"))) {     //если мы уже на странице то никуда не переходить
            return;
        }
        click(By.linkText("home"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public void delete_contact(NewContactData1 contact) {
        changeContactById(contact.getId()); //открыть окно на изменение
        deleteContact_1(); //удаление контакта
        checkContact(); //зайти снова на страницу контактов
    }

    public NewContactData1 infoFromEditForm(NewContactData1 contact) {
        getContactwithoutCheckBoxById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String surname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        checkContact();
        return new NewContactData1()
                .withId(contact.getId()).withFirst_name(firstname).withLast_name(surname).withHome_phone(home)
                .withMobile_phone(mobile).withWork_phone(work);
    }

    public Contacts contact_all() {
        Contacts contacts = new Contacts();

        List<WebElement> elements = wd.findElements(By.xpath(("//tr[@name = 'entry']")));

        for (WebElement element : elements) {

            String name = element.findElement(By.xpath("td[3]")).getText();
            String surname = element.findElement(By.xpath("td[2]")).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // получаем id контакта

            contacts.add(new NewContactData1().withId(id).withLast_name(surname).withFirst_name(name));
        }
        return contacts;
    }


}
