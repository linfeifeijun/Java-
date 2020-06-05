import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter(); //获得输出流
        //从请求对象中获得指定参数的值
        String strName = request.getParameter("txtName");
        String strPwd = request.getParameter("txtPwd");

        out.println("您好！" + strName + " "+strPwd + "<br>");
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        PreparedStatement pstmt;



        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=database_zhanlinfei","LAPTOP-G32N0OF7\HP","");
            String  sql = "select * from users1 where username=? and pwd=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, strName);
            pstmt.setString(2, strPwd);
            rs=pstmt.executeQuery();

            if (rs.next())
            {
                out.println("您好！" + strName + " "+strPwd + "<br>");


            }
            else {

                out.println("错误的用户名和密码");
            }
            rs.close(); 	conn.close();
            //stmt.close();
            pstmt.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }



    // response.sendRedirect("/page/index.html");
       // request.getRequestDispatcher("/page/index.html").forward(request,response);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
