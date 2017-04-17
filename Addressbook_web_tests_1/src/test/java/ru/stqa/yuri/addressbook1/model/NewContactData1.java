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
@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class NewContactData1 {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id= Integer.MAX_VALUE; //не показывать id так как он одинаковый
    @Expose
    @Column(name = "lastname")
    private  String last_name;
    @Expose
    @Column(name = "firstname")
    private  String first_name;

    @Expose
    @Column(name = "middlename")
    private  String middle_name;
    @Expose
    @Column(name = "nickname")
    private  String nick_name;
    @Expose
    @Column(name = "company")
    private  String company_name;
    @Expose
    @Column(name = "mobile")
    @Type(type="text")
    private  String mobile_phone;
    @Expose
    @Column(name = "email")
    @Type(type="text")
    private  String email_1;
    @Expose
    @Column(name = "address")
    @Type(type="text")
    private  String address;
    @Expose
    @Column(name = "home")
    @Type(type="text")
    private  String home_phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewContactData1 that = (NewContactData1) o;

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

    @XStreamOmitField
    @Transient
    private  String work_phone;
    //@XStreamOmitField
    //@Transient
    //private String group;
    @XStreamOmitField
    @Transient
    private File photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name ="id"),
            inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<GroupData1> groups = new HashSet<GroupData1>();

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
    public NewContactData1 withWork_phone(String work_phone) {
        this.work_phone = work_phone;
        return this;
    }

   // public NewContactData1 withGroup(String group) {
    //    this.group = group;
  //      return this;
   // }

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

    public String getWork_phone() {
        return work_phone;
    }

    public String getHome_phone() {
        return home_phone;
    }
  //  public String getGroup() {
      //  return group;
   // }

    public Groups getGroups() {   //Множество переводим в объект типа groups
        return new Groups(groups);
    }

    public NewContactData1 inGroup(GroupData1 group) {
        groups.add(group);
        return this;
    }

 /*   public int getNumberofContactsInGroup(GroupData1 group) {
       return groups.size();
       // return this;
    }*/
}
