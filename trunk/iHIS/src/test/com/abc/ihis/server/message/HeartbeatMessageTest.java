package com.abc.ihis.server.message;

import org.testng.annotations.Test;

import com.abc.ihis.cp.message.HeartbeatRequestMessage;
import com.abc.ihis.cp.message.HeartbeatResponseMessage;
import com.abc.ihis.cp.message.Message;
import com.abc.ihis.cp.message.MessageFactory;

public class HeartbeatMessageTest {
	@Test
	public void requestEncode() {

		HeartbeatRequestMessage req = new HeartbeatRequestMessage();
		req.setSequence("001");
		req.setServer("server1");
		req.setController("controller1");
		String encode = new String(req.encode());

		System.out.println(encode);
	}

	@Test
	public void responseEncode() {

		HeartbeatResponseMessage resp = new HeartbeatResponseMessage();
		resp.setSequence("001");
		resp.setServer("server1");
		resp.setController("controller1");
		resp.setCode("000");
		String encode = new String(resp.encode());
		System.out.println(encode);
	}

	public void responseDecode() {

		String xml = "<response><sequence>001</sequence><server>server1</server><controller>controller1</controller><data><cmd>heart-beat</cmd><code>000</code></data></response>";
		// HeartbeatRespMessage resp = new HeartbeatRespMessage();
		Message message = MessageFactory.createMessage(xml.getBytes());
		message.decode();
		System.out.println(message.encode());
	}
}
