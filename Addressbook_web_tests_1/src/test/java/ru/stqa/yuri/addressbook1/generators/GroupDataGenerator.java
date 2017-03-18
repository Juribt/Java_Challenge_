package ru.stqa.yuri.addressbook1.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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

    @Parameter(names= "-c", description ="Group count") //описание опции счёта строк
    public int count;

    @Parameter(names= "-f", description ="Target file")//описание опции файла
    public String file;

    public static void main (String[] args) throws IOException {
        GroupDataGenerator generator = new  GroupDataGenerator();
     //   new JCommander(generator, args);
        JCommander jCommander = new JCommander(generator);
try {
    jCommander.parse(args); // распарсить запуск
}catch (ParameterException ex){
    jCommander.usage(); //метод, выводящий информацию о доступных опциях
    return;
}
        generator.run();

//int count = Integer.parseInt(args[0]); //считать первую переменную со строки число групп
  //      File file = new File (args[1]); // путь к файлу

//List<GroupData1> groups = generateGroups(count);
  //      save(groups, file);
    }

    private void run() throws IOException {
        List<GroupData1> groups = generateGroups(count);
        save(groups, new File(file));
    }

    private  void save(List<GroupData1> groups, File file) throws IOException { //запись в файл
        System.out.println( new File (".").getAbsolutePath()); //посмотреть какая рабочая директория для save
        Writer writer = new FileWriter(file);
        for (GroupData1 group : groups){
        writer.write(String.format("%s:%s:%s\n", group.getNameGroup(),
                group.getHeaderGroup(), group.getNameFooter()));
        }
        writer.close();
    }

    private  List<GroupData1> generateGroups(int count) { //реализация генератора данных групп
        List<GroupData1> groups = new ArrayList<GroupData1>();
        for (int i=0; i < count ; i++){
            groups.add(new GroupData1().withNameGroup(String.format("test %s", i))
                    .withHeaderGroup(String.format("header %s", i))
                    .withNameFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
