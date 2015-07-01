package com.allstate.auto.pages;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.Validations;
import com.allstate.utilities.Utils.SearchType;

/**
* This class is used to get primary insured household details
* @author Harpreat Singh
* @version 1.0 Apr 04, 2013
*/
public class householdPage extends Validations{

	/** Define all the elements of the Household page */
	//Effective Date
	
	public static final String effMonth_name = "household.effDateMM";
	public static final String effDate_name = "household.effDateDD";
	public static final String effYear_name = "household.effDateYYYY";
	
	//Sub Producer Code
	
	
	//Primary Insured/Occupant 1
	
	public static final String piFirst_name = "occupantInfo[0].firstName";
	public static final String piMiddleInitial_name = "occupantInfo[0].middleInitial";
	public static final String piMonth_name = "occupantInfo[0].dobMM";
	public static final String piDate_name = "occupantInfo[0].dobDD";
	public static final String piYear_name = "occupantInfo[0].dobYYYY";
	public static final String piAge_name = "occupantInfo[0].age";
	public static final String piLastName_name = "occupantInfo[0].lastName";
	public static final String piSuffix_name = "occupantInfo[0].suffix";
	public static final String piSsn1_name = "occupantInfo[0].ssn1Shadow";
	public static final String piSsn2_name = "occupantInfo[0].ssn2Shadow";
	public static final String piSsn3_name = "occupantInfo[0].ssn3";
	public static final String piGender_name = "occupantInfo[0].gender";
	public static final String piGoodHandsInd_name = "occupantInfo[0].goodHandsInd";
	public static final String piMaritalStatus_name = "occupantInfo[0].maritalStatus";
	public static final String piRetiredInd_name = "occupantInfo[0].retiredInd";
	
	
	//Primary Insured License Information
	public static final String piStateLicensed_name = "occupantInfo[0].stateLicensed";
	public static final String piLicenseNumber_name = "occupantInfo[0].licenseNumberMasked";
	
	//Primary Insured Accidents
	public static final String piAccidentsInd_name = "occupantInfo[0].accidentsInd";
	
	//Add Children in Household button
	
	public static final String addChildrenInHousehold_xpath = "//input[@value=\"Add Children in Household\"]";
	
	//Add Another Occupant
	
	public static final String addOccupant_xpath = "//input[@value=\"Add Another Occupant\"]";
	
	//Add Contact Info
	
	public static final String addContactInfo_xpath = "//input[@value=\"Add Contact Info\"]";
	
    //Are the Current Address and the Property to be Insured Address the same?
	
	public static final String propertyToBeInsuredSame_name = "household.isCurrentAddressIsPropertyAddress";
															   
	
	//Residence Information
	
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
	public static final String dba_name = "household.doingBusinessAs";
	public static final String yearsAtCurrentAddress_name = "household.yearsAtCurrentAddress";
	
	//Contact Information
	
    //Home
	public static final String homeAreaCode_name = "household.homePhone.areaCode";
	public static final String homePhoneNumber_name = "household.homePhone.phoneNumber";
	public static final String homePhoneExtension_name = "household.homePhone.extension";
	
	//Business
	
	public static final String businessAreaCode_name = "household.businessPhone.areaCode";
	public static final String businessPhoneNumber_name = "household.businessPhone.phoneNumber";
	public static final String businessPhoneExtension_name = "household.businessPhone.extension";
	
	public static final String emailoptions_name = "household.emailOptionCd";
	public static final String emailAddress_name = "household.emailAddr";
	
	//Quote Mailing Address
	
	public static final String sameAs_name = "household.isMailingAddressSameAsCurrentInd";
	public static final String previewQuoteMailingLabelButton_name = "Preview Quote Mailing Label";
	
	//Good Hands® Roadside 
	
	public static final String goodHand_name = "interestedInGHRInd";
	
	//Life Insurance Information
	
	public static final String haveLifeInsurance_name = "household.hasLifeInsuranceInd";
	
	//Household Details
	
	public static final String noOfClaimsIn5Years_name = "household.numLossesShow";
	public static final String noOfOccupantsInclChild_name = "household.numBoarders";
	public static final String noOfDogs_name = "household.numDogs";
	public static final String householdSmoke_name = "household.doesAnyoneSmoke";
	
	
	//Customer Search
	
	public static final String isInsuredOnAllstate_name = "household.crossIndex.spouseClientSearch.spouseClientSearchSelected";
	
	
	
	//Affinity Relationship 
	
	public static final String affinityQuestion_name = "household.householdAffinity.affinityRequiredQuestion";
	
	// Current Insurance
	
	public static final String lengthOfCurrentCoverage_name = "household.currentInsuranceBean.lengthTimeWithPreviousInsurer";
	
	   //On Selecting None
	public static final String wasThereNeedForInsurance_name = "household.currentInsuranceBean.priorInsuranceNoNeedInd";
	
	   //On Selecting Less than six months or Less than 1 year
	public static final String companySearch_name = "household.currentInsuranceBean.companySearch";
	public static final String company_name = "household.currentInsuranceBean.companyProductCd";
	public static final String yearsWithPriorCarrier_name = "household.currentInsuranceBean.yearsWithPriorCarrier";
	
	  //On Selecting all else below element will be visible additional to above
	
	public static final String priorInsuranceJUA_name = "household.currentInsuranceBean.priorInsuranceJUA";
	
	public static final String typeofPriorInsuranceJUA_name = "household.currentInsuranceBean.typeOfPriorPropertyInsurance";
	
	
	
	
	
	
	//Allstate Supporting Policies
	
	public static final String auto_xpath = "//input[@value=\"001\"]";
	public static final String homeowners_xpath = "//input[@value=\"007\"]";
	public static final String motorCycle_xpath = "//input[@value=\"016\"]";
	public static final String boat_xpath = "//input[@value=\"090\"]";
	public static final String landLords_xpath = "//input[@value=\"072\"]";
	public static final String personalUmbrella_xpath = "//input[@value=\"088\"]";
	public static final String condomonium_xpath = "//input[@value=\"078\"]";
	public static final String mobileHome_xpath = "//input[@value=\"032\"]";
	public static final String renters_xpath = "//input[@value=\"071\"]";
	
	//Vehicle Information
	
	public static final String totalVehicle_name = "household.autoPriorInsuranceBean.totalVehicleInTheHouseholdCd";
	public static final String maxYearsWithCurrentCarrier_name = "household.autoPriorInsuranceBean.lengthWithCurrentInsurance";
	public static final String maxofCurrentBiLimits_name = "household.autoPriorInsuranceBean.priorBILimitAmt";
	
	//Credit Report Information
	
	public static final String propertyCreditInformation_name = "household.creditScore";
	
	

	
	
	
	
	//Continue to Dwelling button
	
	public static final String continueToDwellingButton_class = "button140";
	
	
	//Error Title
	
	public static final String errorValidation_class = "error_title";
	public static final String errorMessage_class = "error_text_pre_special_char";
	
	
	/**			
	* This method checks for errors if an object exists
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing
	*/
	public static void checkErrors(WebDriver driver) throws Exception{
		
		if (Validations.VAL_doesObjectExist(driver, errorValidation_class, SearchType.CLASS, true, "Does the error exist")){
		
		   ReportLog("PASS", "", Actions.ACT_getObjectText(driver, errorMessage_class, SearchType.CLASS));	
	     
	    }else
	    {
	       ReportLog("PASS", "", "No error captured");
	    }
		
	}
	
	
	public void checkdefaultdata(){
		
		//Check for all values 
	}
	
	/**			
	* This method puts keys and values into the HashMap depending upon the given occupant number
	* @param occupantNumber
	* 			The number representing a particular occupant having all the data related to that occupant
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return InsuredData1
	* 			InsuredData1 of type HashMap is returned that contains all the key value pairs
	*/
	public static HashMap insuredInformation (int occupantNumber){
	
	
	
	HashMap<String, String> InsuredData1 = new HashMap<String, String>();
	
	InsuredData1.put("piFirst_name","occupantInfo["+ occupantNumber +"].firstName");
	InsuredData1.put("piMiddleInitial_name","occupantInfo["+ occupantNumber +"].middleInitial");
    InsuredData1.put("piLastName_name","occupantInfo["+ occupantNumber +"].lastName");
    InsuredData1.put("pirelationToPrimary_name","occupantInfo["+ occupantNumber +"].titleRelationshipCd");
	
	InsuredData1.put("piGender_name","occupantInfo["+ occupantNumber +"].gender");
	
	InsuredData1.put("piMonth_name","occupantInfo["+ occupantNumber +"].dobMM");
	InsuredData1.put("piDate_name","occupantInfo["+ occupantNumber +"].dobDD");
	InsuredData1.put("piYear_name","occupantInfo["+ occupantNumber +"].dobYYYY");
	
	InsuredData1.put("piSsn1_name","occupantInfo["+ occupantNumber +"].ssn1Shadow");
	InsuredData1.put("piSsn2_name","occupantInfo["+ occupantNumber +"].ssn2Shadow");
	InsuredData1.put("piSsn3_name","occupantInfo["+ occupantNumber +"].ssn3");
	
	InsuredData1.put("piGoodHandsInd_name","occupantInfo["+ occupantNumber +"].goodHandsInd");
	InsuredData1.put("piRetiredInd_name","occupantInfo["+ occupantNumber +"].retiredInd");
	
	InsuredData1.put("piMaritalStatus_name","occupantInfo["+ occupantNumber +"].maritalStatus");
	
	InsuredData1.put("piRetiredInd_name","occupantInfo["+ occupantNumber +"].retiredInd");
	InsuredData1.put("piRetiredInd_name","occupantInfo["+ occupantNumber +"].retiredInd");
	
	InsuredData1.put("piStateLicensed_name","occupantInfo["+ occupantNumber +"].stateLicensed");
	InsuredData1.put("piLicenseNumber_name","occupantInfo["+ occupantNumber +"].licenseNumberMasked");
	
	return InsuredData1;
	
	
	
	}
	
	/**			
	* This method enters occupant data - Spouse data
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param insuredData 
	* 			The HashMap containing insured data depending on occupant number
	* @param occupantNumber 
	* 			The number representing a particular occupant having all the data related to that occupant
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing 			
	*/
	public static void enterOccupantData(WebDriver driver,HashMap<String,String> insuredData,int occupantNumber) throws Exception{
		int occupantId = occupantNumber+1;
		HashMap<String,String> InsuredData = insuredInformation(occupantNumber);
		
			
		
		Actions.ACT_setText(driver, InsuredData.get("piFirst_name"), SearchType.NAME,insuredData.get("Fname_"+occupantId));
		Actions.ACT_setText(driver, InsuredData.get("piMiddleInitial_name"), SearchType.NAME,insuredData.get("Mname_"+occupantId));
		
	    if(occupantId>2) {   	
		Actions.ACT_dropdownSelect(driver, InsuredData.get("piMaritalStatus_name"), SearchType.NAME, insuredData.get("MaritalStatus_"+occupantId));
		Actions.ACT_dropdownSelect(driver, InsuredData.get("pirelationToPrimary_name"), SearchType.NAME, insuredData.get("RelationToPrimary_"+occupantId));
	    }
	    
	    
	    Actions.ACT_dropdownSelect(driver, InsuredData.get("piGender_name"), SearchType.NAME, insuredData.get("Gender_"+occupantId));
		
		Actions.ACT_setText(driver, InsuredData.get("piMonth_name"), SearchType.NAME,"02");
		Actions.ACT_setText(driver, InsuredData.get("piDate_name"), SearchType.NAME,"02");
		Actions.ACT_setText(driver, InsuredData.get("piYear_name"), SearchType.NAME,"1980");
		
		Actions.ACT_setText(driver, InsuredData.get("piSsn1_name"), SearchType.NAME,"195");
		Actions.ACT_setText(driver, InsuredData.get("piSsn2_name"), SearchType.NAME,"82");
		Actions.ACT_setText(driver, InsuredData.get("piSsn3_name"), SearchType.NAME,"673" + occupantId);
		
		
		
		Actions.ACT_dropdownSelect(driver, InsuredData.get("piGoodHandsInd_name"), SearchType.NAME, insuredData.get("IsEligibleForGoodHandProgram_"+occupantId));
		Actions.ACT_dropdownSelect(driver, InsuredData.get("piRetiredInd_name"), SearchType.NAME, insuredData.get("IsOccupantRetired_"+occupantId));
		
		
		if(occupantId==1)
		{
		Actions.ACT_dropdownSelect(driver, InsuredData.get("piStateLicensed_name"), SearchType.NAME, insuredData.get("StateLicense_"+occupantId));
		Actions.ACT_setText(driver, InsuredData.get("piLicenseNumber_name"), SearchType.NAME, insuredData.get("DriverLicenseNumber_"+occupantId));
		}
	
	
	}
	
	/**			
	* This method is to add details of occupants - everybody other than spouse
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param insuredData 
	* 			The HashMap containing insured data depending on occupant number
	* @param totalNumberOfOccupants 
	* 			The total number of occupants
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing 			
	*/
	public static void addAnotherOccupant(WebDriver driver,HashMap<String,String> insuredData,int totalNumberOfOccupants) throws Exception{
		int addOccupants=0;
		int occupantNumber = 0;
		if(insuredData.get("MaritalStatus_1").equals("Married and lives with Spouse")){
			addOccupants = totalNumberOfOccupants - 2;
			occupantNumber = 1;
		}else{
			addOccupants = totalNumberOfOccupants - 1;
		}
		
		for(int o=0;o<addOccupants;o++){
			occupantNumber = occupantNumber+1;
		//	Actions.ACT_doubleClickObject(driver, addOccupant_xpath, SearchType.XPATH);
		    Actions.ACT_clickObject(driver, addOccupant_xpath, SearchType.XPATH);
			householdPage.enterOccupantData(driver, insuredData, occupantNumber);

				
		}
		
	}
	
	
	
	
	
	/**			
	* This method is to enter all the remaining data related to the occupant
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param insuredData 
	* 			The HashMap containing insured data depending on occupant number
	* @param businessScenarioData 
	* 			The HashMap
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing 			
	*/	
	public static void enterotherdata(WebDriver driver,HashMap<String,String> insuredData,HashMap<String,String> businessScenarioData) throws Exception{
		
				
		if(businessScenarioData.get("IsAddressSame_1").equals("Yes"))
		{
			//Only DBA value has been put . Rest are coming by Default
			
			Actions.ACT_dropdownSelect(driver, propertyToBeInsuredSame_name, SearchType.NAME, businessScenarioData.get("IsAddressSame_1"));
			Actions.ACT_setText(driver, dba_name, SearchType.NAME, businessScenarioData.get("DBA_1"));
			
			
		}else
			
		{
			Actions.ACT_dropdownSelect(driver, propertyToBeInsuredSame_name, SearchType.NAME, businessScenarioData.get("IsAddressSame_1"));
			Actions.ACT_setText(driver, dba_name, SearchType.NAME, businessScenarioData.get("DBA_1"));
			
			//Insured Address not handled
				
		}		
				
	    
		if(businessScenarioData.get("YearsAtCurrentAddress_1").equals("5 Years or More")){
			Actions.ACT_dropdownSelect(driver, yearsAtCurrentAddress_name, SearchType.NAME, businessScenarioData.get("YearsAtCurrentAddress_1"));
			
				
		}else
			
		{
		    //	Previous address not handled
			
		}
		
			
		Actions.ACT_setText(driver, noOfOccupantsInclChild_name, SearchType.NAME, businessScenarioData.get("NoOfChildren_1"));
		
		if(businessScenarioData.get("NoOfDogs_1").equals("0")){
			Actions.ACT_dropdownSelect(driver,noOfDogs_name, SearchType.NAME, businessScenarioData.get("NoOfDogs_1"));	
		
		
		}else
		{
			//Dogs are not handles
		   	
		}
		
		
		Actions.ACT_dropdownSelect(driver,householdSmoke_name, SearchType.NAME, businessScenarioData.get("HouseHoldSmoke_1"));
		
		if(businessScenarioData.get("IsInsuredonAllstate_1").equals("0")){
			
			Actions.ACT_dropdownSelect(driver,isInsuredOnAllstate_name, SearchType.NAME, businessScenarioData.get("IsInsuredonAllstate_1"));
   			
			
		}else
		{
			//if insured already on Allstate in not handled
		}
		
		if(businessScenarioData.get("LengthOfContInsurance_1").equals("None")){
			
			//Not Handled
			
			
		}else if(businessScenarioData.get("LengthOfContInsurance_1").equals("Less than 6 months") || businessScenarioData.get("LengthOfContInsurance_1").equals("Less than 1 year")){
			
		   //Not Handled	
			
		}else
		{
			
			Actions.ACT_dropdownSelect(driver,lengthOfCurrentCoverage_name, SearchType.NAME, businessScenarioData.get("LengthOfContInsurance_1"));
			Actions.ACT_setText(driver, companySearch_name, SearchType.NAME, businessScenarioData.get("CompanySearch_1"));
			
			Thread.sleep(5000);
			
			Actions.ACT_clickObject(driver, householdPage.piFirst_name, SearchType.NAME);
			Actions.ACT_dropdownSelect(driver,company_name, SearchType.NAME, businessScenarioData.get("Company_1"));
			
			Actions.ACT_dropdownSelect(driver,priorInsuranceJUA_name, SearchType.NAME, businessScenarioData.get("priorInsuranceJUA_1"));
			Actions.ACT_dropdownSelect(driver,yearsWithPriorCarrier_name, SearchType.NAME, businessScenarioData.get("YearsWithPriorCarrier_1"));
			Actions.ACT_dropdownSelect(driver,typeofPriorInsuranceJUA_name, SearchType.NAME, businessScenarioData.get("TypeOfPropertyInsurance_1"));
			
		}	
		
			
		Actions.ACT_dropdownSelect(driver,totalVehicle_name, SearchType.NAME, businessScenarioData.get("TotalNoOfVehicles_1"));	
			
			
	    	
		
		
			
			
		
	
		
		
	
	
	
	
	
	}
			
			
			
				
		
	}
	
	
	
	
	 
	
	

	
	
	


