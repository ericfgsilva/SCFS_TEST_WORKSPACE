package pageObjects.General;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static boolean bResult;
	public static String errorMsg;
	
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
		BaseClass.errorMsg = null;
	}

}
