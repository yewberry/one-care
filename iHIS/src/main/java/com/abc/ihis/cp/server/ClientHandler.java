package com.abc.ihis.cp.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.HeartbeatRequestMessage;
import com.abc.ihis.cp.message.HeartbeatResponseMessage;
import com.abc.ihis.cp.message.Message;

/**
 * 消息逻辑处理器
 * 
 * @author chenkaihao
 * 
 */
public class ClientHandler extends IoHandlerAdapter {

	public void sessionCreated(IoSession session) throws Exception {
		// 会话创建
		System.out.println("sessionCreated:" + session);
	}

	public void sessionOpened(IoSession session) throws Exception {
		// 打开会话,与sessionCreated最大的区别是它是从另一个线程处调用的
		System.out.println("sessionOpened:" + session);
	}

	public void sessionClosed(IoSession session) throws Exception {
		// 会话结束，当连接关闭时被调用
		System.out.println("sessionClosed:" + session);
	}

	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// 会话空闲

	}

	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// 异常捕获，Mina会自动关闭此连接
		// super.exceptionCaught(session, cause);
		System.out.println(cause);
	}

	public void messageReceived(IoSession session, Object obj) throws Exception {
		// 忽略其他消息
		if (!(obj instanceof Message)) {
			return;
		}
		Message msg = (Message) obj;
		// 接收到消息
		System.out.println("===messageReceived==" + msg);
		if (msg instanceof HeartbeatRequestMessage) {
			HeartbeatResponseMessage respMsg = new HeartbeatResponseMessage(
					((HeartbeatRequestMessage) msg));
			session.write(respMsg);
		}
		if (session.getAttribute("server") == null) {
			session.setAttribute("server", msg.getController());
		}

	}

	public void messageSent(IoSession session, Object message) throws Exception {
		// 发送消息
		System.out.println("==messageSent==" + message);
	}
}
