package ch.bfh.springerstifu.heroes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.DeleteDbFiles;

public class HelloWorld extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> values = new ArrayList<String>();
        try {
            // delete the database named 'test' in the user home directory
            DeleteDbFiles.execute("~", "test", true);

            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
            Statement stat = conn.createStatement();
            stat.execute("create table test(id int primary key, name varchar(255))");
            stat.execute("insert into test values(1, 'Springer')");
            stat.execute("insert into test values(2, 'Stifu')");
            ResultSet rs;
            rs = stat.executeQuery("select * from test");
            while (rs.next()) {
                // System.out.println(rs.getString("name"));¨
                values.add(rs.getString("name"));
            }
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        // Create Content
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        for (String iStr : values) {
            out.println("<h1>" + iStr + "</h1>");
        }
        // out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}