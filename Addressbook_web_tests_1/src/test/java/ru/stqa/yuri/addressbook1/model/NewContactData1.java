package ru.stqa.yuri.addressbook1.model;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class NewContactData1 {
    private final String last_name;
    private final String first_name;
    private final String middle_name;
    private final String nick_name;
    private final String company_name;
    private final String mobile_phone;
    private final String email_1;
    private final String address;
    private final String home_phone;
    private String group;

    public NewContactData1(String last_name, String first_name, String middle_name, String nick_name, String company_name, String mobile_phone, String email_1, String address, String home_phone, String group) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.nick_name = nick_name;
        this.company_name = company_name;
        this.mobile_phone = mobile_phone;
        this.email_1 = email_1;
        this.address = address;
        this.home_phone = home_phone;
        this.group = group;
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
