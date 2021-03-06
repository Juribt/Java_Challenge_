package ru.stqa.yuri.addressbook1.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
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

    @Parameter(names= "-d", description ="Data format")//описание опции файла
    public String format;

    public static void main (String[] args) throws IOException {
        GroupDataGenerator generator = new  GroupDataGenerator();

        JCommander jCommander = new JCommander(generator);
try {
    jCommander.parse(args); // распарсить запуск
}catch (ParameterException ex){
    jCommander.usage(); //метод, выводящий информацию о доступных опциях
    return;
}
        generator.run();


    }

    private void run() throws IOException {               //анализ форматов
        List<GroupData1> groups = generateGroups(count);
        if(format.equals("csv")){
           saveAsCsv(groups, new File(file));
        }else if (format.equals("xml")){
            saveAsXML(groups, new File(file));
        }else if (format.equals("json")){
            saveAsJson(groups, new File(file));
        }else{
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsJson(List<GroupData1> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);

        try (Writer writer = new FileWriter(file)){  //автоматическое закрытие файла
           writer.write(json);
       }

    }

    private void saveAsXML(List<GroupData1> groups, File file) throws IOException { // переформатировать данные в xml
        XStream xstream = new XStream ();
       xstream.processAnnotations(GroupData1.class); //прочитать подсказки для класса
        String xml = xstream.toXML(groups);

        try ( Writer writer = new FileWriter(file)){ ////автоматическое закрытие файла
            writer.write(xml);
        }

    }

    private  void  saveAsCsv(List<GroupData1> groups, File file) throws IOException { //запись в файл
        System.out.println( new File (".").getAbsolutePath()); //посмотреть какая рабочая директория для save
       try( Writer writer = new FileWriter(file)){
           for (GroupData1 group : groups){ //автоматическое закрытие файла
               writer.write(String.format("%s:%s:%s\n", group.getNameGroup(),
                       group.getHeaderGroup(), group.getNameFooter()));
           }
       }

    }

    private  List<GroupData1> generateGroups(int count) { //реализация генератора данных групп
        List<GroupData1> groups = new ArrayList<GroupData1>();
        for (int i=0; i < count ; i++){
            groups.add(new GroupData1().withNameGroup(String.format("test %s", i))
                    .withHeaderGroup(String.format("header\n %s", i))
                    .withNameFooter(String.format("footer\n %s", i)));
        }
        return groups;
    }
}
