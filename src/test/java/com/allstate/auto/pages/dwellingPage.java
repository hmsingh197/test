package com.allstate.auto.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;
import com.allstate.utilities.Utils.SearchType;

/**
* This class gives the property to be insured details
* @author Harpreat Singh
* @version 1.0 Apr 04, 2013
*/
public class dwellingPage {

	//Property To Be Insured Details
	/** Define all the elements of the Dwelling page identified by name, linktext and Xpath */		
	public static final String originalOwner_name = "dwelling.isOriginalOwner";
	public static final String dwellingCourseOfConst_name = "dwelling.dwellCourseOfConstruction";
	public static final String zip_name = "addressToBeInsured.zipCode";
	public static final String purchaseMonth_name = "dwelling.purchaseDtMM";
	public static final String purchaseYear_name = "dwelling.purchaseDtYYYY";
	public static final String isPrimaryResidence_name = "dwelling.dwellUseCd";
	public static final String isTherePoolOrHot_name = "dwelling.poolOrHotTubInd";
	
	
	//Estimated Replacement Cost
	
	public static final String yearsBuilt_name = "dwelling.replacementCost.yearBuilt";
	public static final String yearRoofInstalled_name = "dwelling.replacementCost.yearRoofInstalled";
	public static final String contructionType_name = "dwelling.replacementCost.constructionCd";
	public static final String roofGeometry_name = "dwelling.replacementCost.roofGeometryCd";
	public static final String hasCertifiedResistanceRoof_name = "dwelling.replacementCost.hailResistantRoofInd";
	public static final String typeOfResidence_name = "dwelling.replacementCost.residenceTypeCd";
	   //If type of residence is Townhouse below element will be displayed dwelling.replacementCost.numUnits
		public static final String noOfUnitsBetweenFirewall_name = "dwelling.replacementCost.numUnits";
	public static final String styleOfHome_name = "dwelling.replacementCost.homeStyle";
	public static final String totalNumberOfRooms_name = "dwelling.replacementCost.totalRoomCount";
	
	 
	//Dwelling Space
	
	public static final String totalLivingArea_name = "dwelling.replacementCost.totalLivingArea";
	public static final String cathedralCeilingFoundation_name = "dwelling.replacementCost.cathedralCeiling";
	public static final String withCrawlSpace_name = "dwelling.replacementCost.foundationCrawlspace";
	public static final String withSlab_name = "dwelling.replacementCost.foundationSlab";
	public static final String withBasement_name = "dwelling.replacementCost.foundationBasement";
	public static final String priorFoundation_name = "dwelling.replacementCost.foundationPier";
	public static final String hillsideFoundation_name = "dwelling.replacementCost.foundationHillside";
	
	//Kitchen
	
	public static final String kitchenQuality_name = "dwelling.replacementCost.kitchenList[0].quality";
	public static final String kitchenQuantity_name = "dwelling.replacementCost.kitchenList[0].quantity";
	
	//Add Another Kitchen Link
	
	public static final String addAnotherKitchenItem_linktext = "Add Another Kitchen Item";
	
	
	
	//Bath
	public static final String bathType_name = "dwelling.replacementCost.bathList[0].type";
	public static final String bathQuality_name = "dwelling.replacementCost.bathList[0].quality";
	public static final String bathQuanity_name = "dwelling.replacementCost.bathList[0].quantity";
	
	
	//Add Another Bath Link
	
	public static final String addAnotherBathItem_linktext = "Add Another Bath Item";
	
	
	//Fireplace/Woodstove(s) 
	
	public static final String firePlaceType_name = "dwelling.replacementCost.fireplaceStoveList[0].type";
	public static final String firePlaceQuantity_name = "dwelling.replacementCost.fireplaceStoveList[0].quantity";
	
	//Add Another Fireplace/Woodstove Link
	
	public static final String addAnotherFireplaceWoodstove_linktext = "Add Another Fireplace/Woodstove Item";
	
	//Deck
	
	public static final String deckType_name = "dwelling.replacementCost.deckList[0].type";
	public static final String deckSqFt_name = "dwelling.replacementCost.deckList[0].squareFoot";
	
	//Add Another Deck Link
	
	public static final String addAnotherDeck_linktext = "Add Another Deck Item";

	//Porch
	
	public static final String porchType_name = "dwelling.replacementCost.porchList[0].type";
	public static final String porchSize_name = "dwelling.replacementCost.porchList[0].size";
	public static final String porchQuantity_name = "dwelling.replacementCost.porchList[0].quantity";
	public static final String porchSqFt_name = "dwelling.replacementCost.porchList[0].squareFoot";
	
	//Add Another Porch Link
	
	public static final String addAnotherPorch_linktext = "Add Another Porch Item";
	
	//Solar Room
	
	public static final String solarType_name = "dwelling.replacementCost.solarRoomList[0].type";
	public static final String solarQuantity_name = "dwelling.replacementCost.solarRoomList[0].quantity";
	
	//Add Another Solar Room Link
	
	public static final String addAnotherSolarRoom_linktext = "Add Another Solar Room Item";
	
	//Garage
	
	public static final String garageSize_name = "dwelling.replacementCost.garageCarportList[0].size";
	public static final String garageType_name = "dwelling.replacementCost.garageCarportList[0].type";
	public static final String garageQuantity_name = "dwelling.replacementCost.garageCarportList[0].quantity";
	
	
	//Add Another Garage Link
	
	public static final String addAnotherGarage_linktext = "Add Another Garage/Carport Item";
	
	
	//Add Structural Features Link

	public static final String addStructuralFeature_linktext = "Add Structural Features";
	
	//Total Structure Estimated Cost
	
	public static final String totalStructureEstimatedCost_name = "dwelling.replacementCost.totalInsurableReplCostAmt";
	
	//Calculate Estimated Replacemnet Cost Button
	
	public static final String calculateEstimatedReplacemnetCostButton_name = "Calculate Estimated Replacement Cost";
	
	//Dwelling Coverage Amount
	
	public static final String dwellingCoverageAmount_name = "dwelling.replacementCost.limitCoverageCd";
	
	//Select Value Endorsement
	
	public static final String selectValueEndorsement_name = "dwelling.replacementCost.selectValue";
	
	//Order Fire Department button
	
	public static final String orderFireDepartment_xpath = "//input[@value=\"Order Fire Department\"]" ;
	
	  //On click of  Order Fire Department button
	public static final String milesToRespondingFireDeptt_name = "dwelling.replacementCost.limitCoverageCd";
	public static final String respondingFireDeptt_name = "dwelling.tclass.fireDistrictName";
	
		
	
	//Number of mortgages
	
	public static final String numberOfMorgages_name = "dwelling.numMortgages";
	
	//Continue to Coverage button
	
	public static final String continueToCoverage_xpath = "//input[@value=\"Continue to Coverages >>\"]" ;
	
	/**			
	* This method enters test data from excel to the application using businessScenarioData HashMap
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param businessScenarioData 
	* 			The HashMap
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing
	*/
	public static void enterstaticdata(WebDriver driver,HashMap<String,String> businessScenarioData) throws Exception{
	
		//Property To Be Insured Details
		
		Actions.ACT_dropdownSelect(driver, originalOwner_name, SearchType.NAME, businessScenarioData.get("OriginalOwner_1"));
		Actions.ACT_dropdownSelect(driver, dwellingCourseOfConst_name, SearchType.NAME, businessScenarioData.get("IsInCourseOfConst_1")) ;
		Actions.ACT_setText(driver, purchaseMonth_name, SearchType.NAME, businessScenarioData.get("PurchaseDateMonth_1")) ;
		Actions.ACT_setText(driver, purchaseYear_name, SearchType.NAME, businessScenarioData.get("PurchaseDateYear_1")) ;
		Actions.ACT_dropdownSelect(driver, isPrimaryResidence_name, SearchType.NAME, businessScenarioData.get("IsPrimaryResidence_1")) ;
		Actions.ACT_dropdownSelect(driver, isTherePoolOrHot_name, SearchType.NAME, businessScenarioData.get("IsHotTub_1")) ;
		
		//Estimated Replacement Cost
		
		Actions.ACT_setText(driver, yearsBuilt_name, SearchType.NAME, businessScenarioData.get("YearBuilt_1")) ;
		Actions.ACT_setText(driver, yearRoofInstalled_name, SearchType.NAME, businessScenarioData.get("YearRoofInstalled_1")) ;
		Actions.ACT_dropdownSelect(driver, contructionType_name, SearchType.NAME, businessScenarioData.get("ConstructionType_1")) ;
		Actions.ACT_dropdownSelect(driver, roofGeometry_name, SearchType.NAME, businessScenarioData.get("RoofGeometry_1")) ;
		
		
		Actions.ACT_dropdownSelect(driver, hasCertifiedResistanceRoof_name, SearchType.NAME, businessScenarioData.get("CertHailedResisRoof_1")) ;
		Actions.ACT_dropdownSelect(driver, typeOfResidence_name, SearchType.NAME, businessScenarioData.get("TypeOfResidence_1")) ;
		
		if(businessScenarioData.get("TypeOfResidence_1").equals("Townhouse")){
			
			Actions.ACT_dropdownSelect(driver, noOfUnitsBetweenFirewall_name, SearchType.NAME, businessScenarioData.get("NoOfUnitsBetweenFirewall_1")) ;
			
		}
				
		Actions.ACT_dropdownSelect(driver, styleOfHome_name, SearchType.NAME, businessScenarioData.get("StyleOfHome_1")) ;
		Actions.ACT_setText(driver, totalNumberOfRooms_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		
		//Dwelling Spaces
				
		
		
		Actions.ACT_setText(driver, totalLivingArea_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		Actions.ACT_setText(driver, cathedralCeilingFoundation_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		Actions.ACT_setText(driver, withCrawlSpace_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		Actions.ACT_setText(driver, withSlab_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		Actions.ACT_setText(driver, withBasement_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		Actions.ACT_setText(driver, priorFoundation_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		Actions.ACT_setText(driver, hillsideFoundation_name, SearchType.NAME, businessScenarioData.get("TotalNumberOfRooms_1")) ;
		
		
		
		
		
		
	}
}
