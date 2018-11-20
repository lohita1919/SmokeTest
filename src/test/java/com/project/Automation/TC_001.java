package com.project.Automation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TC_001 extends BaseTest
{
	public static final Logger log=Logger.getLogger(TC_001.class.getName());
	
  @Test
  public void Amazonsearch() throws Exception 
  {
	  log.info("=====Start TC_001 =======");
	  openBrowser("ChromeBrowser");
	  log.info("Selected the browser------"+ prop.getProperty("ChromeBrowser"));
	  navigate("amazonurl");
	  log.info("Navigated to the URL ------"+ prop.getProperty("amazonurl"));
	  text("searchboxtext_id","sony");
	  log.info("Entered the value into the search button with the locator ID -----" +prop.getProperty("searchboxtext_id"));
	  clickElement("searchbutton_xpath");
	  log.info("Clicked on search button using xpath locator ---- " + prop.getProperty("searchbutton_xpath"));
	  log.info("=====End TC_001 =======");
	  
  }

}
