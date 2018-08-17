package my.education.webapplication.servlets;


import my.education.webapplication.jdbc.service.CacheService;
import my.education.webapplication.jdbc.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bender on 14.08.2018.
 */
@WebServlet(urlPatterns = "/details")
public class DetailsServlet extends HttpServlet {
    @Autowired
    private DBService cacheService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("login", request.getParameter("login"));
        parameters.put("method", request.getMethod());
        parameters.put("locale", request.getLocale());
        parameters.put("URL", request.getRequestURI());
        parameters.put("sessionId", request.getSession().getId());
        parameters.put("parameters", ((CacheService) cacheService).getCacheEngine().toString());
        response.getWriter().println(TemplateProcessor.instance().getPage("details.html", parameters));
    }
}