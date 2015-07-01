package com.allstate.pages.common;

import org.openqa.selenium.WebDriver;

import com.allstate.utilities.Actions;

/*import com.gsicommerce.webstore.testdata.Environment;
import com.gsicommerce.webstore.utilities.Action;*/

public class PageFactory extends Actions {

	
	
	public static AllstatePageFactory getWebstorePages(WebDriver driver) {

		return new AllstatePageFactory(driver);
	}
	
}
