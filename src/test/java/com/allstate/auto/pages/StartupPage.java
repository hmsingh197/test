package com.allstate.auto.pages;

import java.util.HashMap;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.Validations;
import com.allstate.utilities.Utils.SearchType;

/**
* This class is used to get primary insured details and provide order report if any
* @author Harpreat Singh
* @version 1.0 Apr 04, 2013
*/
public class StartupPage {
	
	//Primary Insured Section
	/** Define all the elements of the EasyQuote page */
	public static final String firstName_name = "occupantInfo[0].firstName";
	public static final String middelInitial_name = "occupantInfo[0].middleInitial";
	public static final String lastName_name = "occupantInfo[0].lastName";
	public static final String suffix_name = "occupantInfo[0].suffix";
	public static final String DOB_month_name = "occupantInfo[0].dobMM";
	public static final String DOB_date_name = "occupantInfo[0].dobDD";
	public static final String DOB_year_name = "occupantInfo[0].dobYYYY"; 
	
	
	//Are the Current Address and the Property to be Insured Address the same?
	
	public static final String propertyToBeInsuredSame_name = "household.isCurrentAddressIsPropertyAddress";
	
	//Current Address
	
	public static final String country_name = "household.currentAddressCountryShadow";
	public static final String address_name = "household.currentAddress.addrLine1";
	public static final String apt_name = "household.currentAddress.apt";
	public static final String bldg_name = "household.currentAddress.building";
	public static final String poBox_name = "household.currentAddress.poBox";
	public static final String RRNum_name = "household.currentAddress.ruralRoute";
	public static final String suite_name = "household.currentAddress.suite";
	public static final String city_name = "household.currentAddress.city";
	public static final String state_name = "household.currentAddressStateShadow";
	public static final String zipCode_name = "household.currentAddress.zipCode";
	

	// Easy Quote
	
	public static final String easyQuote_xpath = "//input[@value=\"Easy_Quote\"]";
	
	//Price Estimate
	
	public static final String priceEstimate_xpath = "//input[@value=\"Price_Estimate\"]";
	
	// Retrieve Data and Continue button
	
	public static final String retrieveButton_id = "retrieve_button";
	
	// Exit Button
	
	public static final String exitButton_id = "exit_button";
	
	/**			
	* This method enters the test data from the excel in to appropriate fields
	* It takes input from a hash object, the input parameters are First Name, Middle Initial, Last Name, Suffix, DOB, Address, City, Zip 	
	*
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param insuredId 
	* 			The insured ID
	* @param isPropertyAddressSame
	* 			The parameter to confirm if property address same as current address
	* @param excelFilePath 
	* 			The path of excel from where data is extracted
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing
	*/
	public static void enterPrimaryInsuredInfo(WebDriver driver,String insuredId,String isPropertyAddressSame, String excelFilePath) throws Exception{
			
		
		HashMap<String, String> insuredData = new HashMap<String, String>();
		String sqlQuery = "select * from [Insured$] where InsuredID = " + Integer.parseInt(insuredId);
		insuredData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
		
		
		Actions.ACT_setText(driver, firstName_name, SearchType.NAME, insuredData.get("Fname_1"));
		Actions.ACT_setText(driver, middelInitial_name, SearchType.NAME, insuredData.get("Mname_1"));
		Actions.ACT_setText(driver, lastName_name, SearchType.NAME, insuredData.get("Lname_1"));
		Actions.ACT_setText(driver, suffix_name, SearchType.NAME, insuredData.get("Suffix_1"));
		//insuredData.get("DOB_1")
		Actions.ACT_setText(driver, DOB_month_name, SearchType.NAME, "04");
		Actions.ACT_setText(driver, DOB_date_name, SearchType.NAME, "03");
		Actions.ACT_setText(driver, DOB_year_name, SearchType.NAME, "1980");
		if(isPropertyAddressSame.equals("Yes")){
			Actions.ACT_dropdownSelect(driver, propertyToBeInsuredSame_name, SearchType.NAME, "Yes");
			
			Actions.ACT_setText(driver, address_name, SearchType.NAME, insuredData.get("Address1_1"));
			//code here for APT , Bldg, PO Box etc
			Actions.ACT_setText(driver, city_name, SearchType.NAME, insuredData.get("City_1"));
			Actions.ACT_setText(driver, zipCode_name, SearchType.NAME, insuredData.get("Zip_1"));
			
			
		}else{
			Actions.ACT_dropdownSelect(driver, propertyToBeInsuredSame_name, SearchType.NAME, "No");
			//no is currently not handled
		}
	}
	
	
}
