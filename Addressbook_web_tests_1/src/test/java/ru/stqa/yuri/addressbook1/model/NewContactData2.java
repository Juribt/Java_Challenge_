package ru.stqa.yuri.addressbook1.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bilovyur on 25.01.2017.
 */

public class NewContactData2 {

    private int id= Integer.MAX_VALUE; //не показывать id так как он одинаковый

    private  String last_name;

    private  String first_name;


    private  String middle_name;

    private  String nick_name;

    private  String company_name;

    private  String mobile_phone;

    private  String email_1;
    private  String email_2;
    private  String email_3;

    private  String address;

    private  String home_phone;
    private  String home_phone_1;
    private  String allPhones;
    private  String allEmails;

    public String getAllInf() {
        return allInf;
    }

    public void setAllInf(String allInf) {
        this.allInf = allInf;
    }

    private  String allInf;

    public String getAllEmails() {
        return allEmails;
    }



    public String getAllPhones() {

        return allPhones;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewContactData2 that = (NewContactData2) o;

        if (id != that.id) return false;
        if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
        if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
        if (middle_name != null ? !middle_name.equals(that.middle_name) : that.middle_name != null) return false;
        if (nick_name != null ? !nick_name.equals(that.nick_name) : that.nick_name != null) return false;
        if (company_name != null ? !company_name.equals(that.company_name) : that.company_name != null) return false;
        return mobile_phone != null ? mobile_phone.equals(that.mobile_phone) : that.mobile_phone == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (middle_name != null ? middle_name.hashCode() : 0);
        result = 31 * result + (nick_name != null ? nick_name.hashCode() : 0);
        result = 31 * result + (company_name != null ? company_name.hashCode() : 0);
        result = 31 * result + (mobile_phone != null ? mobile_phone.hashCode() : 0);
        return result;
    }


    private  String work_phone;

    private File photo;


    private Set<GroupData1> groups = new HashSet<GroupData1>();

    public File getPhoto() {
        return photo;
    }

    public NewContactData2 withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return "NewContactData1{" +

                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                '}';
    }
    public NewContactData2 withId(int id) {
        this.id = id;
        return this;
    }

    public NewContactData2 withLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public NewContactData2 withFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public NewContactData2 withMiddle_name(String middle_name) {
        this.middle_name = middle_name;
        return this;
    }

    public NewContactData2 withNick_name(String nick_name) {
        this.nick_name = nick_name;
        return this;
    }

    public NewContactData2 withCompany_name(String company_name) {
        this.company_name = company_name;
        return this;
    }

    public NewContactData2 withMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
        return this;
    }

    public NewContactData2 withEmail_1(String email_1) {
        this.email_1 = email_1;
        return this;
    }
    public NewContactData2 withEmail_2(String email_2) {
        this.email_2 = email_2;
        return this;
    }

    public NewContactData2 withEmail_3(String email_3) {
        this.email_3 = email_3;
        return this;
    }


    public NewContactData2 withAddress(String address) {
        this.address = address;
        return this;
    }

    public NewContactData2 withHome_phone(String home_phone) {
        this.home_phone = home_phone;
        return this;
    }

    public NewContactData2 withHome_phone_1(String home_phone_1) {
        this.home_phone_1 = home_phone_1;
        return this;
    }

    public NewContactData2 withWork_phone(String work_phone) {
        this.work_phone = work_phone;
        return this;
    }

    public NewContactData2 withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
    public NewContactData2 withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public NewContactData2 withAllInf(String allInf) {
        this.allInf = allInf;
        return this;
    }


    public int getId() {
        return id;
    }


    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public String getEmail_1() {
        return email_1;
    }
    public String getEmail_2() {
        return email_2;
    }
    public String getEmail_3() {
        return email_3;
    }
    public String getAddress() {
        return address;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public String getHome_phone() {
        return home_phone;
    }
    public String getHome_phone_1() {return home_phone_1;
    }
  //  public String getGroup() {
      //  return group;
   // }

    public Groups getGroups() {   //Множество переводим в объект типа groups
        return new Groups(groups);
    }

    public NewContactData2 inGroup(GroupData1 group) {
        groups.add(group);
        return this;
    }


}
