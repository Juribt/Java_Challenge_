package ru.stqa.yuri.addressbook;

public class GroupData {
    private final String nameGroup;
    private final String headerGroup;
    private final String nameFooter;

    public GroupData(String nameGroup, String headerGroup, String nameFooter) {
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
}
