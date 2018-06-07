package daoMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoToMySQL {
    final static String draiverMySQl = "com.mysql.jdbc.Driver";
    final static String url = "jdbc:mysql://fk.edu.pl/fkedupl_pwngr";
    final static String uid = "fkedupl_pwn";
    final static String pwd = "pWn20180527";
    private Connection con = null;

    public DaoToMySQL() {
        try {
            Class.forName(draiverMySQl).newInstance();
            con = DriverManager.getConnection(url,uid,pwd);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono sterownika bazy danych");
            System.out.println(e);
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Nie połaczyłem się z bazą " + url);
            System.out.println(e);
            System.exit(1);
        }
    }

    public Connection getCon() {
        return con;
    }
}

