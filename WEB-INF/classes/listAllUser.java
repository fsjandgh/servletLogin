import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listAllUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        db_connect connector = new db_connect();
        String action = "select * from user";
        ResultSet rs = connector.db_query(action);
        try{
            while (rs.next()){
                int db_id = rs.getInt("ID");
                String db_account  = rs.getString("account");
                String db_password = rs.getString("password");
                out.println(db_id);
                out.println(db_account);
                out.println(db_password);
            }
        }catch(SQLException se){
            out.println("sql failed!");
            se.printStackTrace();
        }catch(Exception e){
            out.println("failed!");
            e.printStackTrace();
        }
        connector.db_close();
    }
}
