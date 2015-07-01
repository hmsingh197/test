package com.allstate.auto.tests;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.BasicConfigurator; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.PageFactory;

import com.allstate.auto.pages.StartupPage;
import com.allstate.auto.pages.allianceEasyQuotePage;
import com.allstate.auto.pages.dwellingPage;
import com.allstate.auto.pages.householdPage;
import com.allstate.auto.pages.impersonateMenuPage;
import com.allstate.auto.pages.initializemenuPage;
import com.allstate.pages.common.AllstatePageFactory;
import com.allstate.pages.common.PageFactory;
import com.allstate.utilities.Actions;
import com.allstate.utilities.CommonEnvProperties;
import com.allstate.utilities.DriverDefault;
import com.allstate.utilities.FileIO;
import com.allstate.utilities.ISeleniumTestPart;
import com.allstate.utilities.LogHelper;
import com.allstate.utilities.SeleniumApis;
import com.allstate.utilities.Utils;
import com.allstate.utilities.Validations;
//import com.gsicommerce.webstore.selenium.pages.shopping.HomePage;
//import com.gsicommerce.pages.common.WebstorePageFactory;
import com.allstate.utilities.Utils.SearchType;

/*import com.allstate.integration_tests.ui.demo_objectDefinations;
import com.scalar.selenium_test_helper.CommonEnvProperties;
import com.scalar.selenium_test_helper.DriverDefault;
import com.scalar.selenium_test_helper.ISeleniumTestPart;
import com.scalar.selenium_test_helper.LogHelper;
import com.scalar.selenium_test_helper.SeleniumApis;
import com.scalar.selenium_test_helper.utility.Actions;
import com.scalar.selenium_test_helper.utility.FileIO;
import com.scalar.selenium_test_helper.utility.Validations;*/
/**
 * This is a unit test to test the Agent Search functionality
 * @author Shekhar
 *
 */
//@RunWith(Parameterized.class)
public class ScenarioID2test extends Validations implements ISeleniumTestPart {
	private SeleniumApis apis;
	private WebDriver driver;
	private AllstatePageFactory allstatePageFactory;
	
	private static String WORKING_DIR =  System.getProperty("user.dir");
	String excelFilePath = WORKING_DIR + "\\src\\test\\resources\\ScenarioSheet.xls";
	
	public void setSelenium(SeleniumApis apis, PropertiesConfiguration testData) {
		this.apis = apis;
	}

	@Before
	public void setUp() throws Exception {
		
		DriverDefault.setUp(this);
		//driver = apis.createBrowserDriver("IE");
		String path = apis.getProperty(CommonEnvProperties.BROWSER_PATH);
		System.out.println(path);
		
		String IEDriver = "C:\\IEDriver\\IEDriverServer.exe";
		File file = new File(IEDriver);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit wait
		
		driver.get(path);
		driver.manage().window().maximize();
		Actions.ACT_changeWaitTime(driver, 20);
	//	allstatePageFactory = PageFactory.getWebstorePages(driver);
		
		
	}
	
	@After
	public void addNewDefect() {
		driver.quit();
	//	driver.close();
	}
	
	
	


	@Test
	public void ScenarioID1test() {
		testCaseName = "ScenarioID 2 Test Case";
		String title = "Description still needs to be created";
		try {
						
			LogHelper.logTestCaseHeader(testCaseName, title);
			
			HashMap<String, String> BusinessScenarioData = new HashMap<String, String>();
			String sqlQuery = "select * from [BusinessScenario$] where SCID = 2";
			BusinessScenarioData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
			
			
			HashMap<String, String> insuredData = new HashMap<String, String>();
			sqlQuery = "select * from [Insured$] where InsuredID = 1" ;
			insuredData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
			
			HashMap<String, String> ImpersonateMenuData = new HashMap<String, String>();
			sqlQuery = "select * from [ImpersonateMenu$] where IMID = 1";
			ImpersonateMenuData = FileIO.excelGetTestData(excelFilePath, sqlQuery);
			
			
			//Picking System dates on Impersonate Page. Needs to compare them with dates on initializemenuPage page
			
			String impersonateMonth= Actions.ACT_getObjectText(driver, impersonateMenuPage.month_name, SearchType.NAME);
			String impersonateDate= Actions.ACT_getObjectText(driver, impersonateMenuPage.date_name, SearchType.NAME);
			String impersonateYear= Actions.ACT_getObjectText(driver, impersonateMenuPage.year_name, SearchType.NAME);
			//Launching application with default setup from "ScenarioSheet.xls" 
			
			impersonateMenuPage.launchFromImpersonateMenu(driver, 1, excelFilePath);
	        
			//Validating that by default no checkbox is selected.
			
			Validations.VAL_isObjectSelected(driver, initializemenuPage.customerSearch_xpath, SearchType.XPATH, false, "Checking Customer Search radio button is not selected");
			Validations.VAL_isObjectSelected(driver, initializemenuPage.newQuote_xpath, SearchType.XPATH, false, "Checking New Quote radio button is not selected");
			Validations.VAL_isObjectSelected(driver, initializemenuPage.newBusiness_xpath, SearchType.XPATH, false, "Checking New Business radio button is not selected");
			Validations.VAL_isObjectSelected(driver, initializemenuPage.endorsementTransaction_xpath, SearchType.XPATH, false, "Checking Endorsement radio button is not selected");
			
			
		/*	Validations.VAL_doStringsMatch(Utils.breakdate(ImpersonateMenuData.get("TestSystemDate_1"),"month"), Actions.ACT_getObjectText(driver, initializemenuPage.testSystemDateMM_name, SearchType.NAME),"Checking for MM" ) ;
			Validations.VAL_doStringsMatch(Utils.breakdate(ImpersonateMenuData.get("TestSystemDate_1"),"day"), Actions.ACT_getObjectText(driver, initializemenuPage.testSystemDateDD_name, SearchType.NAME),"Checking for DD" ) ; 			 
			Validations.VAL_doStringsMatch(Utils.breakdate(ImpersonateMenuData.get("TestSystemDate_1"),"year"), Actions.ACT_getObjectText(driver, initializemenuPage.testSystemDateYYYY_name, SearchType.NAME),"Checking for YYYY" ) ; */
			 
			//Validating, by default same dates are displayed as were on Impersonate Page
			
			Validations.VAL_doStringsMatch(impersonateMonth, Actions.ACT_getObjectText(driver, initializemenuPage.testSystemDateMM_name, SearchType.NAME),"Checking for MM" ) ;
			Validations.VAL_doStringsMatch(impersonateDate, Actions.ACT_getObjectText(driver, initializemenuPage.testSystemDateDD_name, SearchType.NAME),"Checking for DD" ) ; 			 
			Validations.VAL_doStringsMatch(impersonateYear, Actions.ACT_getObjectText(driver, initializemenuPage.testSystemDateYYYY_name, SearchType.NAME),"Checking for YYYY" ) ; 
			
			
			//Clicking on the Customer Search and verifying elements are displayed for the same on the webpage
			
			Actions.ACT_clickObject(driver,initializemenuPage.customerSearch_xpath , SearchType.XPATH);
			Validations.VAL_doesObjectExist(driver, initializemenuPage.lastNameCS_name, SearchType.NAME, true, "Checking if Last Name textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.firstNameCS_name, SearchType.NAME, true, "Checking if First Name textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.addressCS_name, SearchType.NAME, true, "Checking if Address textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.phoneAreaCodeCS_name, SearchType.NAME, true, "Checking if Phone Areas Code textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.phonePhoneNumCS_name, SearchType.NAME, true, "Checking if Phone Phone Number textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.stateCS_name, SearchType.NAME, true, "Checking if State dropdown is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.zipCS_name, SearchType.NAME, true, "Checking if Zip textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.policyNumberCS_name, SearchType.NAME, true, "Checking if Policy Number textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.displayDateMonthCS_name, SearchType.NAME, true, "Checking if display date Month textbox displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.displayDateDayCS_name, SearchType.NAME, true, "Checking if display date date textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.displayDateYearCS_name, SearchType.NAME, true, "Checking if display date year textbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.myLocationCS_name, SearchType.NAME, true, "Checking if My Location Checkbox is displayed");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.allLocationsCS_name, SearchType.NAME, true, "Checking if All Locations checkbox is displayed");
			
			
			//Verifying Last Name is mandatory for the Customer Search and Verifying the error message string
			
			Actions.ACT_clickObject(driver,initializemenuPage.selectButton_xpath, SearchType.XPATH);
			Validations.VAL_doesObjectExist(driver, initializemenuPage.errorElementOnIgnoringMandatoryLeftSide_class, SearchType.CLASS, true, "Checking error message on clicking Select withoput giving Last Name : Customer Search");
			Validations.VAL_doStringsMatch(initializemenuPage.errorMessageOnIgnoringLastNameCS_class, Actions.ACT_getObjectText(driver, initializemenuPage.errorElementOnIgnoringMandatoryLeftSide_class, SearchType.CLASS), "Verifying error message string for ignoring Mandatory Last Name for Customer Search") ;
			
			
			//Clicking on New Quote checkbox and validating that Product Type drop down is displayed
			
			Actions.ACT_clickObject(driver,initializemenuPage.newQuote_xpath , SearchType.XPATH);
			Validations.VAL_doesObjectExist(driver, initializemenuPage.productType_name, SearchType.NAME, true, "Checking if Product Type Dropdown comes on clicking New Quote");
			
			//Verifying Product Type is mandatory if New Quote is choosen. Verifying the error message also.
			
			Actions.ACT_clickObject(driver,initializemenuPage.selectButton_xpath, SearchType.XPATH);
			Validations.VAL_doStringsMatch(initializemenuPage.errorMessageOnIgnoringProductTypeNQ_class, Actions.ACT_getObjectText(driver, initializemenuPage.errorElementOnIgnoringMandatoryRightSide_class, SearchType.CLASS), "Verifying error message string for ignoring Mandatory Product Type for New Quote") ;
			
			
			//Clicking on New Business checkbox and validating that Product Type and Subproducercode is displayed
			
			
			Actions.ACT_clickObject(driver,initializemenuPage.newBusiness_xpath ,SearchType.XPATH);
			Validations.VAL_doesObjectExist(driver, initializemenuPage.productType_name, SearchType.NAME, true, "Checking if Product Type Dropdown comes on clicking New Quote");
			Validations.VAL_doesObjectExist(driver, initializemenuPage.subprodCode_name, SearchType.NAME, true, "Checking if Subproducer Code textfield comes on clicking New Business");
			
			//Clicking Endorsement checkbox and verifying Policy Number is displayed. 
			
			
			Actions.ACT_clickObject(driver,initializemenuPage.endorsementTransaction_xpath ,SearchType.XPATH);
			Validations.VAL_doesObjectExist(driver, initializemenuPage.policyNumberEndrs_name, SearchType.NAME, true, "Checking if Policy Numer textfield comes on clicking Endorsement");
			
			
			
			
			
			ReportLog("", "END OF TEST", "TEST COMPLETED");
		     
			 
		      
		
		}
			catch (Exception e) {
			
			
			ReportLog("FAIL", "END OF TEST", "vxvxvxvx");	
			Assert.fail("Test Case failed due to " + e.getMessage() );
			System.out.println(e.getMessage());
		}
	}
	
/*	@Parameterized.Parameters
	public static List<Object[]> data() {
	    return Arrays.asList(new Object[1][0]);
	}*/
	
	
	
}


