package com.allstate.auto.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.Validations;
import com.allstate.utilities.Utils.SearchType;

/**
* This class launches the application from the Impersonate menu page
* @author Harpreat Singh
* @version 1.0 Apr 04, 2013
*/
public class impersonateMenuPage {

	/** Define all the elements of the Impersonate Menu page 
	* Also, define a page element to confirm control is present on the same page */
	public static final String targetSystem_name = "targetSystem";
	public static final String sourceOfLaunchPoint_name = "sourceOfLaunchPoint";
	public static final String role_name = "role";
	public static final String state_name = "state";
	public static final String userNTID_name = "userNTID";
	public static final String functionType_name = "functionType";
	public static final String agentNumber_name = "agentNumber";
	

	public static final String month_name = "sysDtMM";
	public static final String date_name = "sysDtDD";
	public static final String year_name = "sysDtYYYY";
	public static final String testLevel_name = "libLevel";
	
	
	
	public static final String launchButton_name = "launch";
	public static final String impersonateHeading_classname = "alliancetablebar";

	/**			
	* This method checks if the object is present, and then it gets test data from the excel row by row
	* It takes input from a hash object, the input parameters are Target Test System, Source of Launch Point, Role, State, UserNTID, Function Type, Agent Number & Test Level 	
	*
	* @param  driver 
	* 			The Selenium WebDriver instance to connect to the web browser
	* @param imId 
	* 			The impersonation ID
	* @param excelFilePath 
	* 			The path of excel from where data is extracted
	* @throws Exception 
	* 			The main exception class handling all exceptions
	* @see Exception
	* @return Nothing
	*/
	public static void launchFromImpersonateMenu(WebDriver driver,int imId, String excelFilePath) throws Exception{
			
		
		if(Validations.VAL_doesObjectExist(driver, impersonateHeading_classname, SearchType.CLASS, true, "Impersonate menu Exist")){
				
			
			HashMap<String, String> imData = new HashMap<String, String>();
			String sqlQuery = "select * from [ImpersonateMenu$] where IMID= " + imId  ;
			imData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
			Actions.ACT_dropdownSelect(driver, targetSystem_name, SearchType.NAME, imData.get("TargetTestSystem_1"));
			Actions.ACT_dropdownSelect(driver, sourceOfLaunchPoint_name, SearchType.NAME, imData.get("LaunchPoint_1"));
			Actions.ACT_dropdownSelect(driver, role_name, SearchType.NAME, imData.get("Role_1"));
			Actions.ACT_dropdownSelect(driver, state_name, SearchType.NAME, imData.get("State_1"));
			Actions.ACT_dropdownSelect(driver, userNTID_name, SearchType.NAME, imData.get("NTID_1"));
			Actions.ACT_dropdownSelect(driver, functionType_name, SearchType.NAME, imData.get("FunctionType_1"));
			Actions.ACT_setText(driver, agentNumber_name, SearchType.NAME, imData.get("AgentNumber_1"));
			Actions.ACT_dropdownSelect(driver, testLevel_name, SearchType.NAME, imData.get("TestLevel_1"));
			Actions.ACT_clickObject(driver, launchButton_name, SearchType.NAME);
		}
		
		
		
	}
	
	
	
	
	
	
	
}
