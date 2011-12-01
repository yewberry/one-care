package com.abc.ihis.cp.message;

public class MessageType {

	private String command;
	
	private String type;

	public MessageType(String command, String type) {
		super();
		this.command = command;
		this.type = type;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
