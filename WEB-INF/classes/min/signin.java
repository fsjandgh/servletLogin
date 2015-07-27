import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     *@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String account = request.getParameter("signin_account");
        String password = request.getParameter("signin_password");
        db_connect connector = new db_connect();
        user currentUser = new user();
        String action = "select * from user";
        ResultSet rs = connector.db_query(action);
        try{
            while(true){
                if (rs.next()){
                    String db_account  = rs.getString("account");
                    String db_password = rs.getString("password");
                    if(account.equals(db_account)){
                        out.println("Sign in failed! exist the same account"+account+password);
                        break;
                    }
                }
                else {
                    action = "insert into user(account,password) VALUES('"+account+"','"+password+"')";
                    connector.db_insert(action);
                    currentUser.setAccount(account);
                    currentUser.setPassword(password);
                    out.println("Sign in Succeed!The current user is "+currentUser.getAccount());
                    break;
                }
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
