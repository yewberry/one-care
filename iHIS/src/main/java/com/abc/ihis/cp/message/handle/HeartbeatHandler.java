package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.HeartbeatResponseMessage;
import com.abc.ihis.cp.message.Message;

/**
 * 心跳消息处理逻辑
 * 
 * @author chenkaihao
 * 
 */
public class HeartbeatHandler extends MessageHandler {

	@Override
	public void handle(IoSession session, Message message) {
		if (message instanceof HeartbeatResponseMessage) {

		} else {
			this.nextHandler.handle(session, message);
		}
	}

	public void timeout(IoSession session, Message message) {

	}

}
