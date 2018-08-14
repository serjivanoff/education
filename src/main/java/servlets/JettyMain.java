package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bender on 14.08.2018.
 */
public class JettyMain {
    private final static int PORT = 8090;
    private final static String RESOURCES = "html";

    public static void main(String[] args) throws Exception {

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase(RESOURCES);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new DetailsServlet()), "/details");
        context.addServlet(LoginServlet.class, "/login");
        context.setAttribute("cacheParam", getCacheParameters());

        Server server = new Server(PORT);
        server.setHandler(new HandlerList(resourceHandler, context));

        server.start();
        server.join();
    }

    private static Map<String, String> getCacheParameters() {
        Map<String, String> result = new HashMap<>();
        result.put("missCount", "12");
        result.put("hitCount", "112");
        result.put("size", "200");
        return result;
    }
}
