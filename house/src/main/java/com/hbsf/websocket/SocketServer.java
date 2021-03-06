package com.hbsf.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/socketServer/{userid}")
@Component
public class SocketServer {

	private Session session;
	private static Map<String,Session> sessionPool = new HashMap<>();
	private static Map<String,String> sessionIds = new HashMap<>();
	
	@OnOpen
	public void open(Session session,@PathParam(value="userid")String userid){
		System.out.println("走到了open");
		this.session = session;
		sessionPool.put(userid, session);
		sessionIds.put(session.getId(), userid);
	}
	
	@OnMessage
	public void onMessage(String message){
		System.out.println("走到了onMessage");
		System.out.println("当前发送人sessionid为"+session.getId()+"发送内容为"+message);
	}
	
	@OnClose
	public void onClose(){
		System.out.println("走到了onClose");
		sessionPool.remove(sessionIds.get(session.getId()));
		sessionIds.remove(session.getId());
	}
	
    @OnError
    public void onError(Session session, Throwable error) {
		System.out.println("走到了onError");
        error.printStackTrace();
    }
	
	public static void sendMessage(String message,String userId){
//		System.out.println(userId);
		System.out.println("走到了sendMessage");
		Session s = sessionPool.get(userId);
		
		if(s!=null){
			try {
				s.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int getOnlineNum(){
		System.out.println("走到了getOnlineNum");
		return sessionPool.size();
	}
	
	public static String getOnlineUsers(){
		System.out.println("走到了getOnlineUsers");
		StringBuffer users = new StringBuffer();
	    for (String key : sessionIds.keySet()) {
		   users.append(sessionIds.get(key)+",");
		}
	    return users.toString();
	}

	public static void sendAll(String msg) {
		System.out.println("走到了sendAll");
		for (String key : sessionIds.keySet()) {
			sendMessage(msg, sessionIds.get(key));
	    }
	}
}
