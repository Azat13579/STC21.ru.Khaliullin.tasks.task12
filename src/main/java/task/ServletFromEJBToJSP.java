package task;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myjsp")
public class ServletFromEJBToJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InitialContext context = null;

        try {
            context = new InitialContext();
            UserDirectoryEJB mySourceOfProblemsEJB =
                    (UserDirectoryEJB) context.lookup("java:module/UserDirectoryEJB");
            String s = mySourceOfProblemsEJB.getString();
            req.setAttribute("directory", s);

            req.getRequestDispatcher("MyJSP.jsp").forward(req, resp);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}