package com.abc.ihis.cp.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * 消息调度服务器
 * 
 * @author chenkaihao
 * 
 */
public class MessageServer {

	private static final int PORT = 9123;

	private static final int BUFFER_SIZE = 1024;

	private static final int THREAD_POOL_SIZE = 20;
	private IoAcceptor acceptor;

	public void start() throws IOException {
		acceptor = new NioSocketAcceptor();
		// 建立线程池
		Executor threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		// 加入过滤器（Filter）到Acceptor
		acceptor.getFilterChain().addLast("exector",
				new ExecutorFilter(threadPool));
		// 增加日志过滤器
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		// 增加编码过滤器
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new MyProtocolCodecFactory()));
		// 指定业务逻辑处理器
		acceptor.setHandler(new ServerHandler());
		// 设置buffer的长度
		acceptor.getSessionConfig().setReadBufferSize(BUFFER_SIZE);
		// 设置空闲时间
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		// 绑定端口
		acceptor.bind(new InetSocketAddress(PORT));
	}

	public static void main(String[] args) throws Exception {
		MessageServer server = new MessageServer();
		server.start();
	}
}
