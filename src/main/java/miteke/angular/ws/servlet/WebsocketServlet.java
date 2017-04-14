package miteke.angular.ws.servlet;

import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.websocket.server.ServerEndpointConfig;

import miteke.angular.ws.DemoEndpoint;

/**
 * Servlet implementation class WebsocketServlet
 */
@WebServlet(description = "Manage Websocket Tools", urlPatterns = { "/WebsocketServlet" },loadOnStartup=1)
public class WebsocketServlet extends HttpServlet {
	public static Logger logger = Logger.getLogger(WebsocketServlet.class.getName());
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebsocketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		logger.info("Starting web socket component ...");
		ServerEndpointConfig.Builder.create(DemoEndpoint.class, "/echo").build();
		logger.info("web socket component  has been started..");
	}

}
