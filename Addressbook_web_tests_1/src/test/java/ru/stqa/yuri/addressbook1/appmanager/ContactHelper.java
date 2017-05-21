package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.yuri.addressbook1.model.Contacts;
import ru.stqa.yuri.addressbook1.model.Contacts1;
import ru.stqa.yuri.addressbook1.model.NewContactData1;
import ru.stqa.yuri.addressbook1.model.NewContactData2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

        attach(By.name("photo"), newContactData.getPhoto()); //кликнуть по кнопке файл

        type(By.name("company"), newContactData.getCompany_name());
        type(By.name("mobile"), newContactData.getMobile_phone());
        type(By.name("email"), newContactData.getEmail_1());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHome_phone());

        if (creation) {   //если форма создания то выпадающий список должен быть, если нет то выполнение упадёт
            if (newContactData.getGroups().size() > 0) {
                Assert.assertTrue(newContactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroups().iterator().next().getNameGroup()); //выберем имя группы
            } else {        // мы пришли на форму модификации контакта
                Assert.assertFalse(isElementPresent(By.name("new_group"))); //проверка того что на странице модификации контакта не должна находится кнопка группы

            }
        }

    }

    public void fillNewContactForm1(NewContactData2 newContactData, boolean creation) { //заполнение формы нового контакта
        type(By.name("lastname"), newContactData.getLast_name());
        type(By.name("firstname"), newContactData.getFirst_name());
        type(By.name("middlename"), newContactData.getMiddle_name());
        type(By.name("nickname"), newContactData.getNick_name());

        attach(By.name("photo"), newContactData.getPhoto()); //кликнуть по кнопке файл

        type(By.name("company"), newContactData.getCompany_name());
        type(By.name("mobile"), newContactData.getMobile_phone());
        type(By.name("email"), newContactData.getEmail_1());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHome_phone());

        if (creation) {   //если форма создания то выпадающий список должен быть, если нет то выполнение упадёт
            if (newContactData.getGroups().size() > 0) {
                Assert.assertTrue(newContactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroups().iterator().next().getNameGroup()); //выберем имя группы
            } else {        // мы пришли на форму модификации контакта
                Assert.assertFalse(isElementPresent(By.name("new_group"))); //проверка того что на странице модификации контакта не должна находится кнопка группы

            }
        }

    }

    public void fillNewContactForm_file(NewContactData1 newContactData, boolean creation) { //заполнение формы нового контакта
        type(By.name("lastname"), newContactData.getLast_name());
        type(By.name("firstname"), newContactData.getFirst_name());
        type(By.name("middlename"), newContactData.getMiddle_name());
        type(By.name("nickname"), newContactData.getNick_name());

        type(By.name("company"), newContactData.getCompany_name());
        type(By.name("mobile"), newContactData.getMobile_phone());
        type(By.name("email"), newContactData.getEmail_1());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("home"), newContactData.getHome_phone());

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

    public void clickOption(String optionName) {
        //my_select.find_elements( :tag_name => "option" )
//select name="to_group">
        // Select select = (Select)wd.findElement(By.name("to_group"));
        // select.selectByValue(optionName);

        wd.findElement(By.name("to_group")).sendKeys(optionName);
    }

    public void getGroup(Integer group_Id) {
        WebElement group_element = wd.findElement(By.name("group"));//.sendKeys(Integer.toString(group_ID));
        Select mySelect = new Select(group_element);   //выбор группы по id, click по Values
        mySelect.selectByValue(Integer.toString(group_Id));

    }

    public void removeFromGroup() {
        wd.findElement(By.name("remove")).click();
        //name="remove"
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

    public void create_contact1(NewContactData2 contact) { //создание контакта
        createNewContact();
        fillNewContactForm1(contact, true);
        submitNewContact();
        checkContact();
    }

    public void create_contact_file(NewContactData1 contact) { //создание контакта
        createNewContact();
        fillNewContactForm_file(contact, true); ////////////////////проблемная секция
        submitNewContact();
        checkContact();
    }


    public void modifyContact(NewContactData1 contact) { //изменение контакта
        modifyById(contact.getId());
        fillNewContactForm(contact, true);
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

    public void addContactToGroup() {
        wd.findElement(By.cssSelector("input[value='Add to']")).click();
        //<input type="submit" value="Add to" name="add">
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

    public NewContactData2 infoFromEditForm1(NewContactData2 contact) {
        getContactwithoutCheckBoxById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String surname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String home_1 = wd.findElement(By.name("phone2")).getAttribute("value");
        String email_1 = wd.findElement(By.name("email")).getAttribute("value");
        String email_2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email_3 = wd.findElement(By.name("email3")).getAttribute("value");

        checkContact();
        return new NewContactData2()
                .withId(contact.getId()).withFirst_name(firstname).withLast_name(surname).withHome_phone(home)
                .withMobile_phone(mobile).withWork_phone(work).withHome_phone_1(home_1)
                .withEmail_1(email_1).withEmail_2(email_2).withEmail_3(email_3).withAddress(address);
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


    public Contacts1 contact_inf() {
        Contacts1 contacts = new Contacts1();

        List<WebElement> elements = wd.findElements(By.xpath(("//tr[@name = 'entry']")));

        for (WebElement element : elements) {

            String name = element.findElement(By.xpath("td[3]")).getText();
            String surname = element.findElement(By.xpath("td[2]")).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // получаем id контакта

            contacts.add(new NewContactData2().withId(id).withLast_name(surname).withFirst_name(name));
        }
        return contacts;
    }

    public Set<NewContactData2> contact_inf_temp() {
        Set<NewContactData2> contacts = new HashSet<NewContactData2>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
              for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName(("td")));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
                      String allAddress = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();


            contacts.add(new NewContactData2().withId(id).withFirst_name(firstname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(allAddress));

        }


        return contacts;
    }
}
