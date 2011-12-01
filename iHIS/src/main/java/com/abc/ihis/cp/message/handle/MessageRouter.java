package com.abc.ihis.cp.message.handle;

import java.util.Hashtable;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

/**
 * 消息路由
 * 
 * @author chenkaihao
 * 
 */
public class MessageRouter {

	private Map<Identity, IoSession> sessions = new Hashtable<Identity, IoSession>();

	//private static MessageRouter instance = new MessageRouter();

	public void addTargetConnect(Identity identity, IoSession session) {
		sessions.put(identity, session);
	}

	public IoSession getSession(Identity identity) {
		return sessions.get(identity);
	}

	// public static MessageRouter getInstance() {
	// return instance;
	// }

}
