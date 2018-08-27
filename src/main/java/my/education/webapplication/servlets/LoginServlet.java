package my.education.webapplication.servlets;

import com.google.gson.Gson;
import my.education.webapplication.jdbc.UserDTO;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.jdbc.service.FrontService;
import my.education.webapplication.messages.MsgToDb;
import my.education.webapplication.messages.MsgToFront;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
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
    @Autowired
    private FrontService frontService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(TemplateProcessor.instance().getPage("login.html", new HashMap<>()));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        frontService.handle(new MsgToDb("front", "db", getPayloadFromRequest(request)));

        UserDataSet user = getUser(login);
        if ("bender".equals(login)) {
            request.getRequestDispatcher("/details").forward(request, response);
        } else {
            doGet(request, response);
        }
    }

    private String getPayloadFromRequest(HttpServletRequest request) {
        return new Gson().toJson(new UserDTO(request.getParameter("login"), request.getParameter("password")));
    }

    private UserDataSet getUser(String name) {
        UserDataSet[] result = new UserDataSet[]{null};
        Thread thread = new Thread(() -> {
            while (true) {
                result[0] = frontService.getUser(name);
                if (result[0] != null){
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        return result[0];
    }
}
