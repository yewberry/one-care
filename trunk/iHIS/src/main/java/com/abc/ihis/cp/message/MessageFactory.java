package com.abc.ihis.cp.message;

public class MessageFactory {

	public static Message createMessage(MessageType msgType) {
		if (ProtocolCommands.HEARTBEAT.equals(msgType.getCommand())) {
			if ("request".equals(msgType.getType())) {
				return new HeartbeatRequestMessage();
			} else {
				return new HeartbeatResponseMessage();
			}
		}
		throw new UnsupportedOperationException();
	}

	public static Message createMessage(byte[] buf) {
		MessageType msgType = getMessageType(buf);
		if (msgType != null) {
			Message message = createMessage(msgType);
			message.setData(buf);
			return message;
		}
		throw new RuntimeException("Can not get the message type from buffer "
				+ new String(buf));
	}

	public static MessageType getMessageType(byte[] buf) {
		String cmd = null;
		String xml = new String(buf);
		String temp = xml.substring(0, 10);
		String type = null;
		if (temp.indexOf("request") > 0) {
			type = "request";
		} else {
			type = "response";
		}
		int index = xml.indexOf("<cmd>");
		int index2 = xml.indexOf("</cmd>");
		if (index > 0 && index2 > index) {
			cmd = xml.substring(index + 5, index2);
		}
		if (cmd != null && type != null) {
			return new MessageType(cmd, type);
		}
		return null;
	}
}
