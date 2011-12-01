/**
 * 
 */
package com.abc.ihis.cp.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.abc.ihis.cp.message.Message;
import com.abc.ihis.cp.message.MessageFactory;

/**
 * 消息解码器
 * 
 * @author chenkaihao
 * 
 */
public class MyDecoder implements ProtocolDecoder {

	public void decode(IoSession session, IoBuffer buffer,
			ProtocolDecoderOutput out) throws Exception {
		int length = buffer.remaining();
		byte[] buf = new byte[length];
		buffer.get(buf);
		Message message = MessageFactory.createMessage(buf);
		message.decode();
		out.write(message);
	}

	public void dispose(IoSession session) throws Exception {

	}

	public void finishDecode(IoSession session, ProtocolDecoderOutput out)
			throws Exception {

	}

}
