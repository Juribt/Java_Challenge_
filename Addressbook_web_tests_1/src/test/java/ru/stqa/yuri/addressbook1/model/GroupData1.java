package ru.stqa.yuri.addressbook1.model;

import ru.stqa.yuri.addressbook1.tests.TestBase;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class GroupData1 {
    private int id = Integer.MAX_VALUE;
    private String nameGroup;
    private String headerGroup;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData1 that = (GroupData1) o;

        return nameGroup != null ? nameGroup.equals(that.nameGroup) : that.nameGroup == null;

    }

    @Override
    public int hashCode() {
        return nameGroup != null ? nameGroup.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GroupData1{" +
                "nameGroup='" + nameGroup + '\'' +
                ", id='" + id + '\'' +
                '}';
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
