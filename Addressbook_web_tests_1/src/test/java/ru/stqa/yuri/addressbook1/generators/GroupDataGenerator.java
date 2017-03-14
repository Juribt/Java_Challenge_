package ru.stqa.yuri.addressbook1.generators;

import ru.stqa.yuri.addressbook1.model.GroupData1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilovyur on 13.03.2017.
 */
public class GroupDataGenerator {
    public static void main (String[] args) throws IOException {
int count = Integer.parseInt(args[0]); //считать первую переменную со строки число групп
        File file = new File (args[1]); // путь к файлу
List<GroupData1> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<GroupData1> groups, File file) throws IOException { //запись в файл
        System.out.println( new File (".").getAbsolutePath()); //посмотреть какая рабочая директория для save
        Writer writer = new FileWriter(file);
        for (GroupData1 group : groups){
        writer.write(String.format("%s:%s:%s\n", group.getNameGroup(),
                group.getHeaderGroup(), group.getNameFooter()));
        }
        writer.close();
    }

    private static List<GroupData1> generateGroups(int count) { //реализация генератора данных групп
        List<GroupData1> groups = new ArrayList<GroupData1>();
        for (int i=0; i < count ; i++){
            groups.add(new GroupData1().withNameGroup(String.format("test %s", i))
                    .withHeaderGroup(String.format("header %s", i))
                    .withNameFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
