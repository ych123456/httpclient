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
 * 通过httpget模拟查询ip
 */
public class IPHttpGet {

	private String HTTP ="http";
	private String IPURL = "www.ip.cn";
	//private String IP = "101.101.101.101";
	private String CHARTSET = "UTF-8";
	/*
	 * 通过httpget模拟查询ip
	 */
	public String getIpHttpGet45(String ip) throws Exception { 
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 先是设置参数
		URI uri = new  URIBuilder()
		          .setScheme(HTTP)
		          .setHost(IPURL)
		          .setPath("/index.php")
		          .setParameter("ip", ip)
		          .build();
		
		// 设置有参数访问
		HttpGet httpget = new HttpGet(uri);
		
		
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		//设置超时时间
		RequestConfig rec = RequestConfig.custom()
		                    .setConnectTimeout(5000)
		                    .setConnectionRequestTimeout(5000).setSocketTimeout(6000).build();
		httpget.setConfig(rec);
		
		CloseableHttpResponse response = httpclient.execute(httpget);
		// 200
		System.out.println("版本："+response.getProtocolVersion());
		System.out.println("状态码："+response.getStatusLine().getReasonPhrase());
		System.out.println("状态码所有："+response.getStatusLine().toString());
		System.out.println("===============我是认真地分割线=====================================");
		HttpEntity entity = response.getEntity();
		if(entity!=null) {
			// 通过HtmlParse解析抓取的页面
			Page page = HtmlParseUtils.parseHtml(EntityUtils.toString(entity,CHARTSET), "a");
			System.out.println("===============我是Page的分割线=====================================");
			System.out.println(page.getHref());
			System.out.println(page.getCode());
			EntityUtils.consume(entity);
		}
		
		response.close();
		
		return null;
		
	}
}
