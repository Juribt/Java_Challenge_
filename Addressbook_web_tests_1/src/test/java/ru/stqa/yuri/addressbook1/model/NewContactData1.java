package ru.stqa.yuri.addressbook1.model;

import java.io.File;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class NewContactData1 {
    private int id= Integer.MAX_VALUE;;
    private  String last_name;
    private  String first_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewContactData1 that = (NewContactData1) o;

        if (id != that.id) return false;
        if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
        return first_name != null ? first_name.equals(that.first_name) : that.first_name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        return result;
    }

    private  String middle_name;
    private  String nick_name;
    private  String company_name;
    private  String mobile_phone;
    private  String email_1;
    private  String address;
    private  String home_phone;
    private String group;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public NewContactData1 withPhoto(File photo) {
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
    public NewContactData1 withId(int id) {
        this.id = id;
        return this;
    }

    public NewContactData1 withLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public NewContactData1 withFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public NewContactData1 withMiddle_name(String middle_name) {
        this.middle_name = middle_name;
        return this;
    }

    public NewContactData1 withNick_name(String nick_name) {
        this.nick_name = nick_name;
        return this;
    }

    public NewContactData1 withCompany_name(String company_name) {
        this.company_name = company_name;
        return this;
    }

    public NewContactData1 withMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
        return this;
    }

    public NewContactData1 withEmail_1(String email_1) {
        this.email_1 = email_1;
        return this;
    }

    public NewContactData1 withAddress(String address) {
        this.address = address;
        return this;
    }

    public NewContactData1 withHome_phone(String home_phone) {
        this.home_phone = home_phone;
        return this;
    }

    public NewContactData1 withGroup(String group) {
        this.group = group;
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

    public String getAddress() {
        return address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getGroup() {
        return group;
    }
}
