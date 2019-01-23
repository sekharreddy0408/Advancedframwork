package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webconnector {

	private  static  WebDriver driver =null ;
	public WebDriverWait wait= null; 
	public String browser = null;
	public FileInputStream configfile = null;
	public Properties prop = null;

	 
	public  void intialise() throws IOException {
		configfile = new FileInputStream("src\\main\\java\\Config.properties");
		prop = new Properties();
		prop.load(configfile);
      System.out.println("intialised");
	}

	public  String getbrowser() {
		return browser = prop.getProperty("browser");
	}

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	
	public static  void setWebDriver(WebDriver driver) {

		dr.set(driver);
	}

	public static  WebDriver getDriver() {

		return dr.get();

	}

	/////////////////////////////////////// OPEN BROWSER////////////////////////////////////////////////////////
	public  WebDriver open_browser() {
System.out.println("openin brwer");

		if (driver == null) {
			System.out.println("in brwer");
			if (getbrowser().equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Chandra\\Desktop\\Ides\\firefoxdriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				// FirefoxProfile fp = new FirefoxProfile();
				// fp.setPreference("xpinstall.signatures.required", false);
				// fp.setPreference("toolkit.telemetry.reportingpolicy.firstRun",
				// false);
				//

			} else if (getbrowser().equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:/Users/Chandra/Desktop/Ides/C_dr/chromedriver.exe");
			       driver = new ChromeDriver();
			       setWebDriver(driver);
				// org.openqa.selenium.Dimension d = new
				// org.openqa.selenium.Dimension(1024,786);
				// driver.manage().window().setSize(d);

				/*
				 * System.setProperty("webdriver.chrome.driver",
				 * "C:\\Users\\Chandra\\Desktop\\Ides\\cdriver\\chromedriver.exe"
				 * ); DesiredCapabilities capabilities =
				 * DesiredCapabilities.chrome(); ChromeOptions options = new
				 * ChromeOptions(); options.addArguments("test-type");
				 * capabilities.setCapability("chrome.binary",
				 * "C:\\Users\\Chandra\\Desktop\\Ides\\cdriver\\chromedriver.exe"
				 * ); capabilities.setCapability(ChromeOptions.CAPABILITY,
				 * options);
				 * 
				 * driver = new ChromeDriver(capabilities);
				 */

			} else if (getbrowser().equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", "C:\\Users\\Chandra\\Desktop\\Ides\\IE\\IEDriverServer.exe");
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability("nativeEvents", false);
				ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("disable-popup-blocking", true);
				ieCapabilities.setCapability("enablePersistentHover", true);
				driver = new InternetExplorerDriver(ieCapabilities);

			}
		}

		return getDriver();
	}

	public  void gotowebsite() {
            System.out.println("website");
		if (!getDriver().getCurrentUrl().contains("rightmove")) {
			System.out.println("goingtoweb");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			getDriver().get(prop.getProperty("url"));
		}
	}
}
