package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
    static final String url = "jdbc:mysql://127.0.0.1:3306/my_crwaling?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    static final String driver="com.mysql.cj.jdbc.Driver";
    static final String id="root";
    static final String password="9121";

    //static block
    static {
        try {
            Class.forName(driver);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //연결
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,id,password);
    }

    //잘 끊어주기위함
    public static void close(AutoCloseable c) {
        try {
            c.close();
        }catch(Exception e) {
        }
    }

}










