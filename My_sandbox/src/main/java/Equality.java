/**
 * Created by bilovyur on 07.02.2017.
 */
public class Equality {

    public static void main (String[] args){
    String s1 ="firefox " + Math.sqrt(4.0);
        String s2 = "firefox " +"2.0";
        System.out.println(s1==s2);
        System.out.println( s1.equals(s2));
    }
}
