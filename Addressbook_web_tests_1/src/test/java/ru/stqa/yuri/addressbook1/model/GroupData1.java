package ru.stqa.yuri.addressbook1.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


import org.hibernate.annotations.Type;
import ru.stqa.yuri.addressbook1.tests.TestBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by bilovyur on 25.01.2017.
 */
@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData1 {
    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private String nameGroup;
    @Expose
   @Column(name = "group_header")
   @Type(type="text")
    private String headerGroup;
    @Expose
    @Column(name = "group_footer")
    @Type(type="text")
    private String nameFooter;


    public int getId() {

        return id;

    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getHeaderGroup() {
        return headerGroup;
    }

    public String getNameFooter() {
        return nameFooter;
    }

    @Override
    public String toString() {
        return "GroupData1{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData1 that = (GroupData1) o;

        if (id != that.id) return false;
        return nameGroup != null ? nameGroup.equals(that.nameGroup) : that.nameGroup == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameGroup != null ? nameGroup.hashCode() : 0);
        return result;
    }

    public GroupData1 withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData1 withNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public GroupData1 withHeaderGroup(String headerGroup) {
        this.headerGroup = headerGroup;
        return this;
    }

    public GroupData1 withNameFooter(String nameFooter) {
        this.nameFooter = nameFooter;
        return this;
    }
}
