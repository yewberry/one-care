package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * @author chenkaihao
 * 
 */
public interface MessageHandler extends TimeoutListener {

	String getMessageCommand();

	void handle(IoSession session, Message message);
}
