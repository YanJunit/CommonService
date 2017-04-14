package miteke.ws.test;

import javax.websocket.server.ServerEndpointConfig;

import miteke.angular.ws.DemoEndpoint;

public class PublishWebsocket {
	public static void main(String args[]) {
		System.out.println("Start.....");
		ServerEndpointConfig.Builder.create(DemoEndpoint.class, "/echo").build();
	}
}
