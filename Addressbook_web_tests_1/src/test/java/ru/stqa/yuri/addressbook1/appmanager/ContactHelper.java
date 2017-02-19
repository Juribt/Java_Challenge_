package ru.stqa.yuri.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

/**
 * Created by bilovyur on 31.01.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void fillNewContactForm(NewContactData1 newContactData, boolean creation) { //заполнение формы нового контакта
        type(By.name("lastname"),newContactData.getLast_name());
        type(By.name("firstname"),newContactData.getFirst_name());
        type(By.name("middlename"),newContactData.getMiddle_name());
        type(By.name("nickname"),newContactData.getNick_name());
        type(By.name("company"),newContactData.getCompany_name());
        type(By.name("mobile"),newContactData.getMobile_phone());
        type(By.name("email"),newContactData.getEmail_1());
        type(By.name("address"),newContactData.getAddress());
        type(By.name("home"),newContactData.getHome_phone());

        if (creation) {   //если форма создания то выпадающий список должен быть, если нет то выполнение упадёт
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
        } else {        // мы пришли на форму модификации контакта
            Assert.assertFalse(isElementPresent(By.name("new_group"))); //проверка того что на странице модификации контакта не должна находится кнопка группы

        }

        if (isElementPresent(By.name("new_group"))){                  //если элемент есть тогда используем его, еслиего нет то неисспользуем
           new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
       }

           }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }

    public void changeContact(int index) {
      //  wd.findElements(By.name("selected[]")&&isElementPresent(By.cssSelector("td.center"))).get(index).click();
    //    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); //edit contact
     //   wd.findElements(By.name("selected[]").get(index).click();
     //   wd.findElement(By.cssSelector("input[value='" + index + "' ]")).click();
        wd.findElements(By.name("selected[]")).get(index).click(); //выбираем элемент по индексу и кликаем его


    }

    public void Mod_contact(int index) {
        //  wd.findElements(By.name("selected[]")&&isElementPresent(By.cssSelector("td.center"))).get(index).click();
        //    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); //edit contact
        //   wd.findElements(By.name("selected[]").get(index).click();
        //   wd.findElement(By.cssSelector("input[value='" + index + "' ]")).click();
        wd.findElements(By.name("selected[]")).get(index).click(); //выбираем элемент по индексу и кликаем его
        wd.findElements(By.xpath("//td[@class='center']")).get(index).click(); // поиск кнопки изменение контакта

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
     //   .//*[@id='content']/form[2]/div[2]/input
    }

    public boolean isThereAContact() {      //есть ли есть какой-нибудь контакт на странице Контактов
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(NewContactData1 contact) { //создание контакта
        createNewContact();
        fillNewContactForm(contact,true);
        submitNewContact();
        checkContact();
    }
    public void checkContact() { //посмотреть что контакт создался
        if (isElementPresent(By.id("maintable"))){     //если мы уже на странице то никуда не переходить
            return;
        }
        click(By.linkText("home"));
    }

    public int getContactCount() {
      return  wd.findElements(By.name("selected[]")).size();
    }
}
