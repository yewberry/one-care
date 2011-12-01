package com.abc.ihis.cp.message.handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.abc.ihis.cp.message.Message;

/**
 * 消息超时管理器，提供处理消息超时能力
 * 
 * @author chenkaihao
 * 
 */
public class TimeoutManager {
	// 消息超时监听器
	private Map<String, List<TimeoutListener>> timeoutListners = new Hashtable<String, List<TimeoutListener>>();
	// 按FIFO方式保存发送消息的流水号队列
	private LinkedList<StoredSequence> requestMessageList = new LinkedList<StoredSequence>();
	// 根据消息流水号保存消息
	private Map<String, StoredMessage> requestMessageMap = new HashMap<String, StoredMessage>();
	// 超时时间，单位毫秒
	private final static int TIMEOUT = 10000;
	// 消息超时检测时间间隔，单位毫秒
	private final static int SCAN_INTERVAL = 3000;

	/**
	 * 消息超时检测线程
	 */
	public void startScanThread() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(SCAN_INTERVAL);
						long now = System.currentTimeMillis();
						for (StoredSequence ss : requestMessageList) {
							if (now - ss.time > TIMEOUT) {
								// 触发消息超时事件
								notifyMessageTimeout(requestMessageMap
										.get(ss.sequence));
							} else {
								break;
							}
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public void addSendRequestMessage(IoSession session, Message message) {
		long sendTime = message.getSendTime();
		if (sendTime == 0) {
			sendTime = System.currentTimeMillis();
		}
		this.requestMessageList.addLast(new StoredSequence(message
				.getSequence(), sendTime));
		requestMessageMap.put(message.getSequence(), new StoredMessage(session,
				message));
	}

	public synchronized void addTimeoutListener(String msgCommand,
			TimeoutListener listener) {
		List<TimeoutListener> listeners = this.timeoutListners.get(msgCommand);
		if (listeners == null) {
			listeners = new ArrayList<TimeoutListener>(1);
		}
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeMessage(String sequence) {
		this.requestMessageMap.remove(sequence);
		for (StoredSequence ss : requestMessageList) {
			if (ss.sequence.equals(sequence)) {
				requestMessageList.remove(ss);
				break;
			}
		}
	}

	public void removeMessage(Message message) {
		this.removeMessage(message.getSequence());
	}

	/**
	 * 消息超时事件
	 * 
	 * @param message
	 */
	private void notifyMessageTimeout(StoredMessage sm) {
		Message message = sm.message;
		List<TimeoutListener> listeners = this.timeoutListners.get(message
				.getCommand());
		if (listeners != null) {
			for (TimeoutListener listener : listeners) {
				listener.timeout(sm.session, sm.message);
			}
		}
	}

	class StoredSequence {
		long time;// 消息发送时间
		String sequence;// 消息流水号

		public StoredSequence(String t, long time) {
			this.sequence = t;
			this.time = time;
		}
	}

	class StoredMessage {
		IoSession session;
		Message message;

		public StoredMessage(IoSession session, Message message) {
			this.session = session;
			this.message = message;
		}

	}

}
