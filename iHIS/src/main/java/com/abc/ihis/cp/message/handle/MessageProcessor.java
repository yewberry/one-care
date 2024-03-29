package com.abc.ihis.cp.message.handle;

import java.util.Hashtable;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * 消息处理器
 * 
 * @author chenkaihao
 * 
 */
public class MessageProcessor {

	protected TimeoutManager timeoutManager;

	protected MessageRouter router;

	private Map<String, MessageHandler> handlers = new Hashtable<String, MessageHandler>();

	public MessageProcessor() {
	}

	public Map<String, MessageHandler> getHandlers() {
		return handlers;
	}

	public void addHandler(MessageHandler handler) {
		this.getHandlers().put(handler.getMessageCommand(), handler);
		handler.setTimeoutManager(timeoutManager);
		handler.setRouter(getRouter());
	}

	public void setHandlers(Map<String, MessageHandler> handlers) {
		this.handlers = handlers;
		if (this.handlers != null) {
			for (MessageHandler handler : this.handlers.values()) {
				if (handler.getTimeoutManager() == null) {
					handler.setTimeoutManager(timeoutManager);
					handler.setRouter(getRouter());
				}
			}
		}
	}

	public void process(IoSession session, Message message) {
		// 处理消息
		MessageHandler handler = this.getHandlers().get(message.getCommand());
		handler.handle(session, message);
	}

	public TimeoutManager getTimeoutManager() {
		return timeoutManager;
	}

	public void setTimeoutManager(TimeoutManager timeoutManager) {
		this.timeoutManager = timeoutManager;
	}

	public MessageRouter getRouter() {
		return router;
	}

	public void setRouter(MessageRouter router) {
		this.router = router;
	}

}
