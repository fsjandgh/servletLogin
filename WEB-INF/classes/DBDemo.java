import java.sql.*;
import java.util.Properties;
public class DBDemo {
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://127.0.0.1/emotherearth";
    public static void main(String[] args) throws ClassNotFoundException,SQLException { 
        System.out.println(dbClassName);
        Class.forName(dbClassName){
        }catch (ClassNotFoundException se){
            system.out.println("数据库连接失败！");
            se.printStackTrace();
        }
    }
}
