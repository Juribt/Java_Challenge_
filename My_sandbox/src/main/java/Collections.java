import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bilovyur on 12.02.2017.
 */
public class Collections {
    public static void main(String[] args) {
     //   String[] langs = {"Java", "C#", "Python", "PHP"}; //строчное обращение к элементам массива

        List languages = Arrays.asList("Java", "C#", "Python", "PHP");
     /*   languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP"); */

        for (Object l: languages) {
            System.out.println("Я хочу выучить  " + l);
        }

    }
}
