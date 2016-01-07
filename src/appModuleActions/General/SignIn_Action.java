package appModuleActions.General;

import org.openqa.selenium.WebDriver;
import pageObjects.General.LogIn_Page;
import util.Constants;
import util.ExcelUtils;
import util.Log;

public class SignIn_Action {

	public static String Execute(WebDriver driver, int iTestCaseRow) throws Exception{

		String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_UserName);
		Log.info("Username picked from Excel is "+ sUserName );

		String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Password);
		Log.info("Password picked from Excel is "+ sPassword );

		LogIn_Page.txtbx_UserName().sendKeys(sUserName);
		Log.info("Username entered in the Username text box");

		LogIn_Page.txtbx_Password().sendKeys(sPassword);
		Log.info("Password entered in the Password text box");

		LogIn_Page.btn_LogIn().click();
		Log.info("Click action performed on Submit button");

		return sUserName;
	}

}
