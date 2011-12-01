package com.abc.ihis.cp.server;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.abc.ihis.cp.message.HeartbeatRequestMessage;

/**
 * 客户端测试程序
 * 
 * @author chenkaihao
 * 
 */
public class MessageClient {
	public static void main(String[] args) {
		// 创建客户端连接器.
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		// 增加编码过滤器
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new MyProtocolCodecFactory()));
		// 指定业务逻辑处理器
		connector.setHandler(new ClientHandler());
		connector.setConnectTimeoutMillis(3000);
		ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",
				9123));// 建立连接
		cf.awaitUninterruptibly();// 等待连接创建完成

		HeartbeatRequestMessage message = new HeartbeatRequestMessage();
		message.setSequence("0001");
		message.setController("controller1");
		message.setServer("server2");

		cf.getSession().write(message);// 发送消息
		cf.getSession().getCloseFuture().awaitUninterruptibly();// 等待连接断开
		connector.dispose();
	}
}
