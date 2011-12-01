package com.abc.ihis.cp.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.abc.ihis.cp.message.Message;

/**
 * 消息编码器
 * 
 * @author chenkaihao
 * 
 */
public class MyEncoder implements ProtocolEncoder {

	public void dispose(IoSession session) throws Exception {

	}

	public void encode(IoSession session, Object obj, ProtocolEncoderOutput out)
			throws Exception {
		if (obj instanceof Message) {
			Message msg = (Message) obj;
			IoBuffer buffer;
			byte[] buf = msg.encode();
			buffer = IoBuffer.allocate(buf.length, false);
			buffer.put(buf);
			buffer.flip();
			out.write(buffer);
			buffer.free();
		}
	}

}
