package ru.stqa.yuri.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.yuri.addressbook1.model.GroupData1;
import ru.stqa.yuri.addressbook1.model.Groups;

import java.sql.*;

/**
 * Created by bilovyur on 02.04.2017.
 */
public class DbConnectionTest {

    @Test
    public void testDbConnection()
    {
        Connection conn = null;

        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC


            Statement st = conn.createStatement();

            ResultSet rs= st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");//запрос к базе данных
// Do something with the Connection
            Groups groups = new Groups(); //сохраняем в коллекцию объекты
            while(rs.next()){
             groups.add(new GroupData1().withId(rs.getInt("group_id"))
                        .withNameGroup(rs.getString("group_name")).withHeaderGroup(rs.getString("group_header")).withNameFooter(rs.getString("group_footer")));
            }

            rs.close(); //закрыть соединение, освободить память
            st.close(); //закрыть statement, так как запросы не будут запускаться в БЛ
            conn.close(); //закрыть соединение с базой данных
            System.out.println(groups);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
