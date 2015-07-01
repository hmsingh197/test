package com.allstate.auto.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.Validations;
import com.allstate.utilities.Utils.SearchType;

/**
* This class is to simply retrieve consumer reports
* @author Harpreat Singh
* @version 1.0 Apr 04, 2013
*/
public class allianceEasyQuotePage {

	//Yes
	
	public static final String yes_xpath = "//input[@value=\"Y\"]";
	
	//No
	
	public static final String no_xpath = "//input[@value=\"N\"]";
	
	//ok
	
	public static final String ok_name = "OK";
	
	/**			
	* This method checks if the primary insured requires consumer reports and retrieves it
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param orderCustomerReports 
	* 			The value of the radio button consumer reports	
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing
	*/
	public static void orderCustomerReports(WebDriver driver,String orderCustomerReports) throws Exception{
			
		
		if (orderCustomerReports.equals("Yes")){
			
			Actions.ACT_clickObject(driver, yes_xpath, SearchType.XPATH);
		}
		else
		{
			Actions.ACT_clickObject(driver, no_xpath, SearchType.XPATH);
		}
		
	}
}
