package com.xinzuini.test;

import org.junit.Test;

import com.xinzuini.httpget.IPHttpGet;

/*
 * ����ip��ѯ
 * @������
 */
public class HttpGetIPTest {

	private String IP = "101.101.101.101";
	
	@Test
	public void testGetIp() throws Exception {  
		IPHttpGet ip = new IPHttpGet();
		ip.getIpHttpGet45(IP);
	}
}
