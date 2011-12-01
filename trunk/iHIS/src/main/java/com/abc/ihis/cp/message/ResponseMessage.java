package com.abc.ihis.cp.message;


/**
 * 响应消息
 * 
 * @author chenkaihao
 * 
 */
public abstract class ResponseMessage extends Message {

	protected String code;

	protected String error;

	public ResponseMessage() {
		this.type = "response";
	}

	public ResponseMessage(RequestMessage requestMessage) {
		this.type = "response";
		this.setSequence(requestMessage.getSequence());
		this.setServer(requestMessage.getServer());
		this.setController(requestMessage.getController());
		this.setClient(requestMessage.getClient());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
