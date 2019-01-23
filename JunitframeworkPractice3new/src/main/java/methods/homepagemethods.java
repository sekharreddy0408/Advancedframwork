package methods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.webconnector;

public class homepagemethods extends webconnector{


	
	
	@FindBy(id="buy")
    public  WebElement clickOnArrangementbutton;
	
	
	public  void clickbutton() throws IOException{
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}              // waitforelementtoappear(clickOnArrangementbutton);
             
       clickOnArrangementbutton.click();

	}

	
	public  void handleAlert(){
		getDriver().switchTo().alert().accept();
	}
		
}
