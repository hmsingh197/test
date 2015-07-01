package com.allstate.auto.tests;

import java.io.InputStream;
import java.util.HashMap;

import com.allstate.utilities.XmlParser;

public class test {

	public void mainCreditCards (String page,String element) {
		HashMap<String, String> hm = XmlParser.getDataNode(getClass().getResourceAsStream("/objectRepository.xml"), page,element);
	//	HashMap<String, String> hm = XmlParser.getDataNode(getClass().getResourceAsStream("/com/test/test/creditcards.xml"), page,element);
	//	System.out.println("hi");
		String value=hm.get("value"); 
		String searctype=hm.get("searchtype");
		System.out.println(value);
		System.out.println(searctype);
	}

	public static void main(String[] args){
		
		test test1 = new test();
		test1.mainCreditCards("Customer Search","initializeMenuPage");
	}
	
}
