package ru.stqa.yuri.addressbook1;

/**
 * Created by bilovyur on 25.01.2017.
 */
public class GroupData1 {
    private final String nameGroup;
    private final String headerGroup;
    private final String nameFooter;

    public GroupData1(String nameGroup, String headerGroup, String nameFooter) {
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
