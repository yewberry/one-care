package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * 控制器连接消息处理逻辑
 * 
 * @author chenkaihao
 * 
 */
public class ControllerConnectHandler implements MessageHandler {

	public void handle(IoSession session, Message message) {

	}

	public void timeout(IoSession session, Message message) {

	}

	public String getMessageCommand() {
		//TODO
		return null;
	}

}
