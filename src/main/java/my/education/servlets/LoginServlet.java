package my.education.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by bender on 14.08.2018.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(TemplateProcessor.instance().getPage("login.html", new HashMap<>()));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login"), password = request.getParameter("password");
        if ("bender".equals(login) && "bender".equals(password)) {
            request.getRequestDispatcher("/details").forward(request, response);
        } else {
            doGet(request, response);
        }
    }
}
