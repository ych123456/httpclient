package com.xinzuini.test;

import org.junit.Test;

import com.xinzuini.httpget.DoHttpGet;

/*
 * httpget�ĵ�Ԫ����junit
 * @������
 */
public class HttpGetTest {

	/*
	 *����httpGet45�ĵ������
	 *1.���Բ��ö���
	 *2.Ҳ���ô�ӡ���ķ�ʽ
	 *3.����ԭ�������1.δ���junit��jar����2.���򴴽��ն���
	 */
	@Test
	public void test001() { 
		
		DoHttpGet hg = new DoHttpGet();
		hg.httpGet45();
	}
}
