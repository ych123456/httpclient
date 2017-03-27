package com.xinzuini.httpget;

import java.io.IOException;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class DoHttpGet implements HttpUriRequest{
	
	private String GETURL = "http://www.baidu.com";
	private String CHARTSET = "UTF-8";
	/*
	 * httpClient4.5��ץȡʵս
	 */
	public void httpGet45(){
		// 1.�½�hc���� 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 2.ѡ��get����
		HttpGet httpget = new HttpGet(GETURL);
		// 3.�޲���
		// 4.ִ��httpResponse����
		CloseableHttpResponse response = null;
		try {
			
			// Ϊ�˺����� response�ܹرգ���Ҫ��response������ǰ
			response= httpClient.execute(httpget);
			// 5.��ӡ��״̬��ͻ�ȡhttpentity����
			// ��ӡ��ֵ
			System.out.println("��ӡ��http�İ汾��Ϣ"+response.getProtocolVersion());
			// ���磺200  OK
			System.out.println("��ӡ��http��״̬��"+response.getStatusLine().getReasonPhrase());
			System.out.println("��ӡ��http��״̬������Ϣ"+response.getStatusLine().toString());
			
			System.out.println("=====================================���ǻ����ķָ���==============================");
			HttpEntity entity = response.getEntity();
			// ���200�Ļ�,���Բ�����һ��
			if(entity!=null) {
				System.out.println(""+entity.getContentLength());
				System.out.println(EntityUtils.toString(entity,CHARTSET)); // ��ֹ����
				EntityUtils.consume(entity);
			}
			
			
		} catch (ClientProtocolException e) { 
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}  finally {
			try {
				// 6.�ر���������
				response.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		
		
	}
	@Override
	public RequestLine getRequestLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHeader(Header arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsHeader(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Header[] getAllHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getFirstHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header[] getHeaders(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getLastHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpParams getParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProtocolVersion getProtocolVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeaderIterator headerIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeaderIterator headerIterator(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeHeader(Header arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeHeaders(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeader(Header arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeaders(Header[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParams(HttpParams arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abort() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAborted() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
