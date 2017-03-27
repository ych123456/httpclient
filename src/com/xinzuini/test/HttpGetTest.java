package com.xinzuini.test;

import org.junit.Test;

import com.xinzuini.httpget.DoHttpGet;

/*
 * httpget的单元测试junit
 * @心醉你
 */
public class HttpGetTest {

	/*
	 *测试httpGet45的调用情况
	 *1.可以采用断言
	 *2.也采用打印出的方式
	 *3.错误原因分析：1.未添加junit的jar包。2.程序创建空对象
	 */
	@Test
	public void test001() { 
		
		DoHttpGet hg = new DoHttpGet();
		hg.httpGet45();
	}
}
