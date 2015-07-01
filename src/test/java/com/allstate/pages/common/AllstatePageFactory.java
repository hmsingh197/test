package com.allstate.pages.common;

import org.openqa.selenium.WebDriver;

import com.allstate.auto.pages.impersonateMenuPage;
import com.allstate.auto.pages.initializemenuPage;
import com.allstate.pages.common.PageFactory;


public class AllstatePageFactory extends PageFactory {
	
	private final impersonateMenuPage impersonateMenu;
	private final initializemenuPage initializemenu;
	
	public AllstatePageFactory(final WebDriver driver) {
				
		impersonateMenu = new impersonateMenuPage();
		initializemenu = new initializemenuPage();
	}
	
	
	
	public impersonateMenuPage impersonateMenu() {
		return impersonateMenu;
	}
	
	public initializemenuPage initializemenu() {
		return initializemenu;
	}


}
