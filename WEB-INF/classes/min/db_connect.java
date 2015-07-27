import java.sql.*;

public class db_connect {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/login";

    static final String USER = "root";
    static final String PASS = "password";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public db_connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet db_insert(String action){
        try{
            stmt.executeUpdate(action);
            return rs;
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet db_query(String action){
        try{
            rs = stmt.executeQuery(action);
            return rs;
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public void db_close(){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se2){
        }// nothing we can do
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    }
}
