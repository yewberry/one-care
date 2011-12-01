package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * @author chenkaihao
 * 
 */
public abstract class MessageHandler implements TimeoutListener {

	protected TimeoutManager timeoutManager;

	protected MessageRouter router;

	public abstract String getMessageCommand();

	public abstract void handle(IoSession session, Message message);

	public TimeoutManager getTimeoutManager() {
		return timeoutManager;
	}

	public void setTimeoutManager(TimeoutManager timeoutManager) {
		this.timeoutManager = timeoutManager;
		this.timeoutManager.addTimeoutListener(getMessageCommand(), this);
	}

	public MessageRouter getRouter() {
		return router;
	}

	public void setRouter(MessageRouter router) {
		this.router = router;
	}

}
