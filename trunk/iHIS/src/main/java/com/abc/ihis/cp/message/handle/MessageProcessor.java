package com.abc.ihis.cp.message.handle;

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

	protected MessageHandler handler;

	public MessageProcessor() {
		// 构建消息处理责任链
		MessageHandler handler = new HeartbeatHandler();
		handler.setTimeoutManager(getTimeoutManager());
		handler.chain(new ControllerConnectHandler());
		// TODO 添加其他消息处理

	}

	public void process(IoSession session, Message message) {
		// 开始处理
		handler.handle(session, message);
	}

	public TimeoutManager getTimeoutManager() {
		return timeoutManager;
	}

	public void setTimeoutManager(TimeoutManager timeoutManager) {
		this.timeoutManager = timeoutManager;
	}

}
