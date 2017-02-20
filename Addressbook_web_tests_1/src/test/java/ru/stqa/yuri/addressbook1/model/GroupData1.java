package ru.stqa.yuri.addressbook1.model;

import ru.stqa.yuri.addressbook1.tests.TestBase;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class GroupData1 {
    private int id;
    private final String nameGroup;
    private final String headerGroup;
    private final String nameFooter;



    public int getId() {

        return id;
    }

    public GroupData1(int id, String nameGroup, String headerGroup, String nameFooter) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.headerGroup = headerGroup;
        this.nameFooter = nameFooter;

    }

    public GroupData1(String nameGroup, String headerGroup, String nameFooter) {
        this.id = Integer.MAX_VALUE;
        this.nameGroup = nameGroup;
        this.headerGroup = headerGroup;
        this.nameFooter = nameFooter;

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

    public void setId(int id) {
        this.id = id;
    }


}
