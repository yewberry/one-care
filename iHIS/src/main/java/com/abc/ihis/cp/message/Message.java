package com.abc.ihis.cp.message;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 消息基类
 * 
 * @author chenkaihao
 * 
 */
public abstract class Message {
	protected String type;// 消息类型，分为request和response
	/**
	 * 消息头由命令字、序列号、服务器、控制器、客户端组成， 其中控制器和客户端非必选
	 */
	protected String command;// 命令字
	protected String sequence;// 流水号
	protected String server;// 服务器
	protected String controller;// 控制器
	protected String client;// 客户端

	protected long sendTime;// 发送时间

	protected byte[] buf;// 消息字节表示

	protected Element xmlRoot;// 内部使用，解析消息用

	public Message() {

	}

	public Message(byte[] buf) {
		this.buf = buf;
	}

	/**
	 * 编码消息头
	 * 
	 * @return
	 */
	public String encodedHeader() {
		StringBuilder sb = new StringBuilder();
		sb.append("<cmd>").append(this.command).append("</cmd>");
		sb.append("<sequence>").append(sequence).append("</sequence>");
		sb.append("<server>").append(server).append("</server>");
		if (controller != null) {
			sb.append("<controller>").append(controller)
					.append("</controller>");
		}
		if (client != null) {
			sb.append("<client>").append(client).append("</client>");
		}
		return sb.toString();
	}

	/**
	 * 解码消息头
	 */
	protected void decodeHeader() {
		if (buf == null) {
			return;
		}
		try {
			String xml = new String(buf).trim();
			Document document = DocumentHelper.parseText(xml);
			this.xmlRoot = document.getRootElement();
			this.type = xmlRoot.getName();
			this.command = xmlRoot.elementText("cmd");
			this.sequence = xmlRoot.elementText("sequence");
			this.server = xmlRoot.elementText("server");
			Element e = xmlRoot.element("controller");
			if (e != null) {
				this.controller = e.getText();
			}
			e = xmlRoot.element("client");
			if (e != null) {
				this.client = e.getText();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 消息体编码，由子类实现
	 * 
	 * @return
	 */
	protected abstract String encodedBody();

	/**
	 * 消息体解码，由子类实现
	 */
	protected abstract void decodeBody();

	/**
	 * 消息解码
	 */
	public void decode() {
		this.decodeHeader();
		this.decodeBody();
	}

	/**
	 * 消息编码
	 * 
	 * @return 字节数组，方便与C语言通信
	 */
	public byte[] encode() {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + type + ">");
		sb.append(this.encodedHeader());
		String body = this.encodedBody();
		if (body != null) {
			sb.append("<data>");
			sb.append(this.encodedBody());
			sb.append("</data>");
		}
		sb.append("</" + type + ">");
		return sb.toString().getBytes();
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public long getSendTime() {
		return sendTime;
	}

	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return buf;
	}

	public void setData(byte[] buf) {
		this.buf = buf;
	}

}
