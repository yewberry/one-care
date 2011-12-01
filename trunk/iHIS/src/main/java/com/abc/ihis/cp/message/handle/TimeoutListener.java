package com.abc.ihis.cp.message.handle;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * 消息超时监听器
 * @author chenkaihao
 *
 */
public interface TimeoutListener {
	public void timeout(IoSession session,Message message);
}
