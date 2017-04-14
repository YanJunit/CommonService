package miteke.angular.ws;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/delayedecho")
public class DemoEndpointAnnotation {
	
	@OnOpen
	public void open(Session session){
		session.getUserProperties().put("previousMsg", "Stupid Mankind");
	}
	
	@OnMessage
	public void message(Session session,String msg){
		String prev = (String) session.getUserProperties().get("previousMsg");
		session.getUserProperties().put("previousMsg", msg);
		try{
			session.getBasicRemote().sendText(prev);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
