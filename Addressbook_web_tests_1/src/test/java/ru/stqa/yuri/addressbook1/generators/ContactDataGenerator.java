package ru.stqa.yuri.addressbook1.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.yuri.addressbook1.model.NewContactData1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilovyur on 26.03.2017.
 */
public class ContactDataGenerator {
    @Parameter(names= "-c", description ="Contact count") //описание опции счёта строк
    public int count;

    @Parameter(names= "-f", description ="Target file")//описание опции файла
    public String file;

    @Parameter(names= "-d", description ="Data format")//описание опции файла
    public String format;
    public static void main (String[] args) throws IOException {
        ContactDataGenerator contact_generator = new  ContactDataGenerator();

        JCommander jCommander = new JCommander(contact_generator);
        try {
            jCommander.parse(args); // распарсить запуск
        }catch (ParameterException ex){
            jCommander.usage(); //метод, выводящий информацию о доступных опциях
            return;
        }
        contact_generator.run();

    }

    private void run() throws IOException {               //анализ форматов
        List<NewContactData1> contacts = generateContacts(count);
        if(format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        }else if (format.equals("xml")){
            saveAsXML(contacts, new File(file));
        }else if (format.equals("json")){
            saveAsJson(contacts, new File(file));
        }else{
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsJson(List<NewContactData1> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
       try( Writer writer = new FileWriter(file)){ //автоматическое закрытие файла
           writer.write(json);
       }

    }

    private void saveAsXML(List<NewContactData1>contacts, File file) throws IOException { // переформатировать данные в xml
        XStream xstream = new XStream ();
        xstream.processAnnotations(NewContactData1.class); //прочитать подсказки для класса
        String xml = xstream.toXML(contacts);
       try( Writer writer = new FileWriter(file)){ //автоматическое закрытие файла
           writer.write(xml);
       }

    }

    private  void  saveAsCsv(List<NewContactData1> contacts, File file) throws IOException { //запись в файл
        System.out.println( new File (".").getAbsolutePath()); //посмотреть какая рабочая директория для save
        try(Writer writer = new FileWriter(file)){
            for (NewContactData1 contact : contacts){
                writer.write(String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s\n", contact.getLast_name(),
                        contact.getFirst_name(), contact.getMiddle_name(),
                        contact.getNick_name(), contact.getCompany_name(),contact.getMobile_phone(),
                        contact.getEmail_1(), contact.getAddress(), contact.getHome_phone()));
            }
        }

    }

    private  List<NewContactData1> generateContacts(int count) { //реализация генератора данных групп
        List<NewContactData1> contacts = new ArrayList<NewContactData1>();
        for (int i=0; i < count ; i++){
            contacts.add(new NewContactData1().withLast_name(String.format("New_Test %s", i))
                    .withFirst_name(String.format("TestHelloo %s", i))
                    .withMiddle_name(String.format("TestTest %s", i))
                  .withNick_name("Test_data_test")
                   .withCompany_name("Test_High_Technologies")
                   .withMobile_phone("89526656583")
                    .withEmail_1("john_swift@yahoo.com")
                   .withAddress("England, Solsbery, Flint str, h 7, fl. 8")
                   .withHome_phone("6402780")
            );
        }
        return contacts;
    }
}
