package com.abc.ihis.cp.message;

/**
 * 心跳请求消息
 * 
 * @author chenkaihao
 * 
 */
public class HeartbeatRequestMessage extends RequestMessage {

	public HeartbeatRequestMessage() {
		this.setCommand(ProtocolCommands.HEARTBEAT);
	}

	@Override
	public String encodedBody() {
		return null;
	}

	@Override
	protected void decodeBody() {

	}

}
