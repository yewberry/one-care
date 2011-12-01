package com.abc.ihis.cp.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 
 * @author chenkaihao
 * 
 */
public class MyProtocolCodecFactory implements ProtocolCodecFactory {

	private MyDecoder messageDecoder;
	private MyEncoder messageEncoder;

	public MyProtocolCodecFactory() {
		this.messageDecoder = new MyDecoder();
		this.messageEncoder = new MyEncoder();
	}

	public ProtocolDecoder getDecoder(IoSession session) throws Exception {

		return messageDecoder;
	}

	public ProtocolEncoder getEncoder(IoSession session) throws Exception {

		return messageEncoder;
	}
}
