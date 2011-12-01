package com.abc.ihis.cp.message;

import org.dom4j.Element;

/**
 * 心跳回复消息
 * 
 * @author chenkaihao
 * 
 */
public class HeartbeatResponseMessage extends ResponseMessage {

	public HeartbeatResponseMessage() {
		this.setCommand(ProtocolCommands.HEARTBEAT);
	}

	public HeartbeatResponseMessage(RequestMessage requestMessage) {
		super(requestMessage);
		this.setCommand(ProtocolCommands.HEARTBEAT);
	}

	@Override
	public String encodedBody() {
		if (this.code != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("<code>").append(this.code).append("</code>");
			if (this.error != null) {
				sb.append("<error>").append(this.error).append("</error>");
			}
			return sb.toString();
		}
		return null;
	}

	@Override
	protected void decodeBody() {
		Element data = this.xmlRoot.element("data");
		this.code = data.elementText("code");
		Element errorElement = data.element("error");
		if (errorElement != null) {
			this.error = errorElement.getText();
		}
	}
}
