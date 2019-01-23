package Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class util  extends webconnector{

	public WebElement waitforelementtoappear( WebElement element) throws IOException {

		wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.elementToBeClickable(element));

		}
}
