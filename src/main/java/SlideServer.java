import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Author: Mat Schaffer <matschaffer@netflix.com>
 * Created: 8/10/13 11:53 PM
 */
public class SlideServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        RevealHandler revealHandler = new RevealHandler();

        ResourceHandler pwdHandler = new ResourceHandler();
        pwdHandler.setResourceBase(".");

        ResourceHandler resourceHandler = new ResourceHandler();
        pwdHandler.setResourceBase(SlideServer.class.getResource(".").getPath());

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { revealHandler, pwdHandler, resourceHandler });
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
