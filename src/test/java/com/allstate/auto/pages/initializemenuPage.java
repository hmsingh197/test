package com.allstate.auto.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.Validations;
import com.allstate.utilities.Utils.SearchType;

/**
* This class is to initialize a new transaction type for a particular agent
* @author Harpreat Singh
* @version 1.0 Apr 04, 2013
*/
public class initializemenuPage {

	/** Define all the elements of the Main Menu page identified by name and Xpath
	* Also, define all the elements when radio buttons are enabled on the page */
	public static final String agent_name = "agentNumber";
	public static final String ratingsState_name = "ratingState";
	public static final String testLevel_name = "systemDateLibraryBean.libLevel";
	
	
	//Development and Testing Only
	
	public static final String testSystemDateMM_name = "systemDateLibraryBean.startDateMM" ;
	public static final String testSystemDateDD_name = "systemDateLibraryBean.startDateDD" ;
	public static final String testSystemDateYYYY_name = "systemDateLibraryBean.startDateYYYY" ;
		
	//Policy View
	  //Customer Search
		
	public static final String custSearch_xpath = "//input[@value=\"CS\"]";
		//Elements on clicking the Customer Search
	public static final String lastNameCS_name = "customerSearchCriteriaBean.policySearchLastName" ;
	public static final String firstNameCS_name = "customerSearchCriteriaBean.policySearchFirstName" ;
	public static final String addressCS_name = "customerSearchCriteriaBean.policySearchAddress" ;
	public static final String phoneAreaCodeCS_name = "customerSearchCriteriaBean.policySearchAreaCode" ;
	public static final String phonePhoneNumCS_name = "customerSearchCriteriaBean.policySearchPhoneNumber" ;
	public static final String stateCS_name = "customerSearchCriteriaBean.policySearchState" ;
	public static final String zipCS_name = "customerSearchCriteriaBean.policySearchZip" ;
	public static final String policyNumberCS_name = "customerSearchCriteriaBean.policySearchPolicyNumber" ;
	public static final String displayDateMonthCS_name = "customerSearchCriteriaBean.policyAsOfDateMM" ;
	public static final String displayDateDayCS_name = "customerSearchCriteriaBean.policyAsOfDateDD" ;
	public static final String displayDateYearCS_name = "customerSearchCriteriaBean.policyAsOfDateYYYY" ;
	public static final String myLocationCS_name = "customerSearchCriteriaBean.policySearchLocation" ;
	public static final String allLocationsCS_name = "customerSearchCriteriaBean.policySearchLocation" ;
	
	
	//Error message elements on ignoring mandatory element. This is irrespective of error message
	public static final String errorElementOnIgnoringMandatoryLeftSide_class = "errorMsgLeftSide" ;
	public static final String errorElementOnIgnoringMandatoryRightSide_class = "errorMsgRightSide" ;
	
	
	
	// Error message for ignoring Last Name and clicking Select button
	
	public static final String errorMessageOnIgnoringLastNameCS_class = "Last/Business Name: This information is required. " ; 
	
	
	//  New Quote radio button
	
	public static final String newQuote_xpath = "//input[@value=\"NQ\"]";
	
	// Error message for ignoring Product Type and clicking Select button
	
	public static final String errorMessageOnIgnoringProductTypeNQ_class = "\"Product Type\" is required to create a New Quote. " ;
	
	
	// New Business radio button
	public static final String newBusiness_xpath = "//input[@value=\"New\"]";
	
	// Endorsement
	
	public static final String endorsementTransaction_xpath = "//input[@value=\"EE\"]";
	public static final String policyNumberEndrs_name = "createNewTransactionBean.endorsementPolicyNumber";
	
	
	
	// Existing Quote radio button
	
	public static final String searchTransaction_xpath = "//input[@value=\"EQ\"]";
	
	// Customer Search radio button
	public static final String customerSearch_xpath = "//input[@value=\"CS\"]";
	
	
	//On click of Customer Search
	public static final String custSearchLastName_name = "customerSearchCriteriaBean.policySearchLastName";
	public static final String custSearchFirstName_name = "customerSearchCriteriaBean.policySearchFirstName";
	public static final String custSearchAddress_name = "customerSearchCriteriaBean.policySearchAddress";
	public static final String custSearchPhoneAreaCode_name = "customerSearchCriteriaBean.policySearchAreaCode";
	public static final String custSearchPhoneNumber_name = "customerSearchCriteriaBean.policySearchPhoneNumber";
	public static final String custSearchState_name = "customerSearchCriteriaBean.policySearchState";
	public static final String custSearchZipCode_name = "customerSearchCriteriaBean.policySearchZip";
	public static final String custSearchEmailAddress_name = "customerSearchCriteriaBean.policySearchEmailAddress";
	public static final String custSearchPolicyNumber_name = "customerSearchCriteriaBean.policySearchPolicyNumber";
	public static final String custSearchPolicyMM_name = "customerSearchCriteriaBean.policyAsOfDateMM";
	public static final String custSearchPolicyDD_name = "customerSearchCriteriaBean.policyAsOfDateDD";
	public static final String custSearchPolicyYYYY_name = "customerSearchCriteriaBean.policyAsOfDateYYYY";
	public static final String custSearchMyLocation_xpath = "//input[@value=\"my\"]";
	public static final String custSearchAllLocation_xpath = "//input[@value=\"all\"]";
	
	
	
	
	//On click of New Quote
	public static final String productType_name = "createNewTransactionBean.productType";
	
	//On click of New business
	public static final String subprodCode_name = "createNewTransactionBean.subProducerCode";
	
	
	//On click of Existing Quote
	public static final String search_productType_name = "existingProductType";
	public static final String lastName_name = "lastName";
	public static final String firstName_name = "firstName";
	public static final String type_name = "status";
	
	
		
	public static final String selectButton_xpath = "//input[@value=\"Select\"]";

	/**			
	* This method checks which transaction type is enabled
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param transactiontype 
	* 			The type of transaction eg. New Quote, New Business
	* @param productType 
	* 			The type of product eg. HomeOwners
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing
	*/
	public static void selectTransactionType(WebDriver driver,String transactionType,String productType) throws Exception{
			
		
	if(transactionType=="New Quote"){
	
		Actions.ACT_clickObject(driver,newQuote_xpath,SearchType.XPATH);
		Actions.ACT_dropdownSelect(driver, productType_name, SearchType.NAME,productType ) ;
	
	}
		
	else if(transactionType=="New Business")
	{
		Actions.ACT_clickObject(driver,newBusiness_xpath,SearchType.XPATH);
		
	
	}
	else if(transactionType=="Endorsement")
	{
		Actions.ACT_clickObject(driver,endorsementTransaction_xpath,SearchType.XPATH);
		
	}
	else if(transactionType=="Customer Search")
	{
		Actions.ACT_clickObject(driver,customerSearch_xpath,SearchType.XPATH);
		
	}
	else if(transactionType=="Existing Quote")
	{
		Actions.ACT_clickObject(driver,searchTransaction_xpath,SearchType.XPATH);
		
	}
			
		
	}
	
	
	
	
}
