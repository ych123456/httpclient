package com.xinzuini.utils;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.xinzuini.bean.Page;

public class HtmlParseUtils {
 

	
	public static Page parseHtml(String html,String e) { 
		Page page = new Page();
		Document document = Jsoup.parse(html);
	    Elements links = document.getElementsByTag(e);
	    
	    Map<String, String> map = new HashMap<String, String>();
	     
	    for (int i = 0; i < links.size(); i++) {
	        Element link = links.get(i);
	        
	        map.put(link.attr("href"), link.text());
	    }
	    
	    page.setHref(map);
	    
	    // ÐÄ×íÄã ÀÏÊ¦
	    Elements paragraphs = document.getElementsByTag(e);
	    StringBuffer plainText = new StringBuffer(html.length() / 2);
	    for (int i = 0; i < paragraphs.size(); i++) {
	        Element paragraph = paragraphs.get(i);
	        plainText.append(paragraph.text()).append("\n");
	    }
	    
	    page.setCode(plainText.toString());
	    
		return page; 
	 
	    
	}
	
	 
}