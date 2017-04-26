package model;

/**
 * Created by bilovyur on 26.04.2017.
 */
public class MailMessage {
    public String to;                     //кому пришло письмо
    public String text;                   //текст письма

    public MailMessage(String to, String text){
        this.to=to;
        this.text = text;
    }
}
