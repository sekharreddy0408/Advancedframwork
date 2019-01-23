package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.util;
import Utilities.webconnector;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import methods.homepagemethods;

public class homepagestepdefs extends webconnector{


	public homepagemethods homepage_method;
  //  public WebDriver dri=null;
	
    public homepagestepdefs() throws IOException  {
   //del start
    	System.out.println("first");
    	intialise();
    	open_browser();
    	gotowebsite();
    	homepage_method  = new homepagemethods();
    	
 //   	del end
    	
    	/*	System.out.println("first");
    	intialise();
    	this.dri=open_browser();
        homepage_method  =PageFactory.initElements(dri,homepagemethods.class);
        gotowebsite();*/
    }
    
	@Before()
	public void firstbefore() throws IOException{
		System.out.println("Before Method");
		System.out.println("*************");
    			
	}
	

	@Given("^First scenario first line$")
	public void first_scenario_first_line() throws IOException   {
	    System.out.println("First Line First Scenario");
	    homepage_method.clickbutton();
	}

	
	@Then("^First scenario handle alert$")
	public void first_scenario_handle_alert()  {
		  System.out.println("First scenario handle alert");
		  homepage_method.handleAlert();
	}
	
}
