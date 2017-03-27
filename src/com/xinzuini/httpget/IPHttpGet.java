package com.xinzuini.httpget;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.xinzuini.bean.Page;
import com.xinzuini.utils.HtmlParseUtils;

/*
 * ͨ��httpgetģ���ѯip
 */
public class IPHttpGet {

	private String HTTP ="http";
	private String IPURL = "www.ip.cn";
	//private String IP = "101.101.101.101";
	private String CHARTSET = "UTF-8";
	/*
	 * ͨ��httpgetģ���ѯip
	 */
	public String getIpHttpGet45(String ip) throws Exception { 
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// �������ò���
		URI uri = new  URIBuilder()
		          .setScheme(HTTP)
		          .setHost(IPURL)
		          .setPath("/index.php")
		          .setParameter("ip", ip)
		          .build();
		
		// �����в�������
		HttpGet httpget = new HttpGet(uri);
		
		
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		//���ó�ʱʱ��
		RequestConfig rec = RequestConfig.custom()
		                    .setConnectTimeout(5000)
		                    .setConnectionRequestTimeout(5000).setSocketTimeout(6000).build();
		httpget.setConfig(rec);
		
		CloseableHttpResponse response = httpclient.execute(httpget);
		// 200
		System.out.println("�汾��"+response.getProtocolVersion());
		System.out.println("״̬�룺"+response.getStatusLine().getReasonPhrase());
		System.out.println("״̬�����У�"+response.getStatusLine().toString());
		System.out.println("===============��������طָ���=====================================");
		HttpEntity entity = response.getEntity();
		if(entity!=null) {
			// ͨ��HtmlParse����ץȡ��ҳ��
			Page page = HtmlParseUtils.parseHtml(EntityUtils.toString(entity,CHARTSET), "a");
			System.out.println("===============����Page�ķָ���=====================================");
			System.out.println(page.getHref());
			System.out.println(page.getCode());
			EntityUtils.consume(entity);
		}
		
		response.close();
		
		return null;
		
	}
}
