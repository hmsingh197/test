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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
import com.allstate.utilities.Validations;
//import com.gsicommerce.webstore.selenium.pages.shopping.HomePage;
//import com.gsicommerce.pages.common.WebstorePageFactory;
import com.allstate.utilities.Actions.actions;
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
public class testCases extends Actions implements ISeleniumTestPart {
	private SeleniumApis apis;
	private WebDriver driver;
	private AllstatePageFactory allstatePageFactory;
	HashMap<String, String> testList = new HashMap<String, String>();
	private static String WORKING_DIR =  System.getProperty("user.dir");
	
	String testFolderPath = WORKING_DIR + "\\src\\test\\resources";
	String excelTestList = WORKING_DIR + "\\src\\test\\resources\\TestExecutionList.xls";
	Actions action = new Actions();
	public void setSelenium(SeleniumApis apis, PropertiesConfiguration testData) {
		this.apis = apis;
	}

	@Before
	public void setUp() throws Exception {
		
		
		String sqlQuery = "select * from [testList$] where Id=1 ";
		testList = FileIO.excelGetTestData(excelTestList, sqlQuery);
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
	public void testCase() {
		testCaseName = testList.get("TestCaseName_1");
		String title = testList.get("TestDescription_1");
		try {
						
			LogHelper.logTestCaseHeader(testCaseName, title);
			
			HashMap<String, String> testData = new HashMap<String, String>();
			String sqlQuery = "select * from [TestCase$] where StepId=1";
			String test= testFolderPath+ "\\" + testList.get("TestCaseName_1") + ".xls" ;
	//		System.out.println(testFolderPath);
			
		//	testData = FileIO.excelGetTestData(test,sqlQuery);
			
		
			
			String mySqlQuery = "select COUNT(*) as \"StepId\" from [TestCase$] ";

			String numberOfSteps = FileIO.excelGetOneData(test, mySqlQuery);
       //   System.out.println("numberOfSteps:" + numberOfSteps);
			
        //  System.out.println("numberOfSteps Int:" + Integer.parseInt(numberOfSteps));
			
			
			
			for(int stepId=1; stepId<= Integer.parseInt(numberOfSteps) ;stepId++){
				
				HashMap<String, String> stepData = new HashMap<String, String>();
				String sqlQueryTestStep = "select * from [TestCase$] where StepId=" + stepId;
			//	System.out.println(sqlQueryTestStep);
				stepData = FileIO.excelGetTestData(testFolderPath+ "\\" + testList.get("TestCaseName_1") + ".xls",sqlQueryTestStep);
				stepData.put("testFolderPath", testFolderPath);
				action.callAction(driver,stepData );
				Thread.sleep(5000);
				
			} 
			
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


