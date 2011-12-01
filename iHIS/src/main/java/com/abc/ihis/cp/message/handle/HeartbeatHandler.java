package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.HeartbeatResponseMessage;
import com.abc.ihis.cp.message.Message;
import com.abc.ihis.cp.message.ProtocolCommands;

/**
 * 心跳消息处理逻辑
 * 
 * @author chenkaihao
 * 
 */
public class HeartbeatHandler extends MessageHandler {

	public void handle(IoSession session, Message message) {
		
	}

	public void timeout(IoSession session, Message message) {

	}

	public String getMessageCommand() {
		return ProtocolCommands.HEARTBEAT;
	}

}
