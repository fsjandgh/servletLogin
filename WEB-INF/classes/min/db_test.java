import java.sql.*;

public class db_test{
    public static void main(String[] args){
        db_connect connector = new db_connect();
        String action = "select * from user";
        ResultSet rs = connector.db_query(action);
        try{
            while(rs.next()){
                //Retrieve by column name
                String account  = rs.getString("account");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                System.out.print("ID: " + id);
                System.out.print(", account: " + account);
                System.out.println(", password: " + password);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        connector.db_close();
    }
}
