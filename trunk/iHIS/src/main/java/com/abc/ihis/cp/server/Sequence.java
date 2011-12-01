package com.abc.ihis.cp.server;

import java.util.Calendar;

/**
 * 序列号生成器
 * 
 * @author chenkaihao
 * 
 */
public class Sequence {

	private String date;
	private long index;

	private static Sequence instance = new Sequence();

	public static Sequence getInstance() {
		return instance;
	}

	public String nextValue() {
		String today = getDateString();
		synchronized (this) {
			if (!today.equals(date)) {
				date = today;
				index = 0;
			}
			return date + getIndexValue();
		}
	}

	private String getIndexValue() {
		StringBuilder sb = new StringBuilder(String.valueOf(++index));
		while (sb.length() < 10) {
			sb.insert(0, '0');
		}
		return sb.toString();

	}

	private String getDateString() {
		Calendar cl = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append(cl.get(Calendar.YEAR));
		int m = cl.get(Calendar.MONTH) + 1;
		if (m < 10) {
			sb.append('0');
		}
		sb.append(m);
		sb.append(cl.get(Calendar.DATE));
		return sb.toString();
	}

}
