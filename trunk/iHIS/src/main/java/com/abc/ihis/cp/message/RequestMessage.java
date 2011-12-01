package com.abc.ihis.cp.message;

public abstract class RequestMessage extends Message {

	public RequestMessage() {
		this.type = "request";
	}

}
