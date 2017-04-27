package model;

import com.google.gson.annotations.Expose;
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bilovyur on 25.01.2017.
 */
//@XStreamAlias("group")
@Entity
@Table(name = "mantis_user_table")
public class UsersData1 {
//    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
 //   @Expose
    @Column(name = "username")
    private String nameUser;
 //   @Expose
    @Column(name = "email")
  //  @Type(type = "text")
    private String emailUser;
 //   @Expose
 //   @Column(name = "group_footer")
 //   @Type(type = "text")
 //   private String nameFooter;

 //   @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
 //   private Set<NewContactData1> contacts = new HashSet<NewContactData1>();

    //public Set<NewContactData1> getContacts() {
    //    return contacts;
   //}

 //   public Contacts getContacts() {
 //       return new Contacts(contacts);
  //  }

    public int getId() {
        return id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

  /*  public int getId() {

        return id;

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
*/


    public UsersData1 withId(int id) {
        this.id = id;
        return this;
    }

    public UsersData1 withNameUser(String nameUser) {
        this.nameUser = nameUser;
        return this;
    }

    public UsersData1 withEmailUser(String emailUser) {
        this.emailUser = emailUser;
        return this;
    }

   /* public GroupData1 withNameFooter(String nameFooter) {
        this.nameFooter = nameFooter;
        return this;
    }*/
}
