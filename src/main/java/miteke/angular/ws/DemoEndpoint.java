package miteke.angular.ws;

import java.util.logging.Logger;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class DemoEndpoint extends Endpoint {
	public static Logger logger = Logger.getLogger(DemoEndpoint.class.getName());

	@Override
	public void onOpen(Session session, EndpointConfig arg1) {
		
		session.addMessageHandler((MessageHandler.Whole<String>) message -> {
			try {
				logger.info("Received Message:\n"+message);
				session.getBasicRemote().sendText(message);
			} catch (Exception e) {
				logger.info("Occurd a problem ,the exception message is :" + e.getMessage() + "\n" + e.getStackTrace());
			}
		});
		
		
	}
}
