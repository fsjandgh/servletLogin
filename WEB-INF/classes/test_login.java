import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test_login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        db_connect connector = new db_connect();
        Connection conn = connector.connect();
        String action = "select * from user";
        Statement stmt = connector.createStatement(conn);
        ResultSet rs = connector.db_query(action,stmt);
        try{
            while(true){
                if (rs.next()){
                    String db_account  = rs.getString("account");
                    String db_password = rs.getString("password");
                    if(account == db_account&&password == db_password){
                        out.println(" logInSuccess! The current user is "+account);
                        break;
                    }
                }
                else {
                    out.println("logInFailed! check your username or password!");
                    break;
                }
            }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        connector.db_close(rs,stmt,conn);
    }
}
