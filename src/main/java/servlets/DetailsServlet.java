package servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by bender on 14.08.2018.
 */
public class DetailsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("login", request.getParameter("login"));
        parameters.put("method", request.getMethod());
        parameters.put("locale", request.getLocale());
        parameters.put("URL", request.getRequestURI());
        parameters.put("sessionId", request.getSession().getId());
        StringJoiner sj = new StringJoiner("; ");
        ((HashMap<String, String>)(request.getServletContext()
                .getAttribute("cacheParam"))).entrySet().forEach(e->
                sj.add(e.getKey()+ ":" + e.getValue()));
        parameters.put("parameters", sj.toString());

        response.getWriter().println(TemplateProcessor.instance().getPage("details.html", parameters));
    }
}