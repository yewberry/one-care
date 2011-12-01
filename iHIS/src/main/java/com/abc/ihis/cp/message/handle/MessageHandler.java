package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * 采用责任链模式处理消息
 * 
 * @author chenkaihao
 * 
 */
public abstract class MessageHandler implements TimeoutListener {

	protected TimeoutManager timeoutManager;

	protected MessageHandler nextHandler;

	public void setTimeoutManager(TimeoutManager timeoutManager) {
		this.timeoutManager = timeoutManager;
		this.timeoutManager.addTimeoutListener(this);
	}

	public abstract void handle(IoSession session, Message message);

	public MessageHandler chain(MessageHandler handler) {
		this.nextHandler = handler;
		this.nextHandler.setTimeoutManager(timeoutManager);
		return this.nextHandler;
	}
}
