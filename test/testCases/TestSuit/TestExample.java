package testCases.TestSuit;

import appModuleActions.Status.CreateWorkflowStatus_Action;
import appModuleActions.General.SignIn_Action;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.General.BaseClass;
import pageObjects.Status.StatusList_Page;
import util.Constants;
import util.Log;
import util.TestLinkResultsManager;
import util.Utils;

public class TestExample {
	
	private static WebDriver driver = null;
	private static String sTestCaseName;
	private static int iTestCaseRow;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		Utils.configureTest(Constants.File_TestData_US001);
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		iTestCaseRow = Utils.getRowContains(sTestCaseName, Constants.Col_TestCaseName);
		Log.logTestDescription(sTestCaseName, iTestCaseRow);
		driver = Utils.openBrowser(iTestCaseRow);
		new BaseClass(driver);  
	}
	
	@Test
	public static void AUT_001() throws Exception {
		
		try {

            SignIn_Action.Execute(driver, iTestCaseRow);
            assertion(CreateWorkflowStatus_Action.Execute(driver, iTestCaseRow, true));

            if (BaseClass.bResult == false) {
                throw new Exception(BaseClass.errorMsg);
            }
        }catch (Exception e){
			Utils.takeScreenshot(driver, sTestCaseName);
			Log.error(e.getMessage());
            BaseClass.errorMsg = e.getMessage();
            BaseClass.bResult = false;
			throw (e);
		}
	}
	
	public static void assertion(String sName) throws Exception{

		String msg = StatusList_Page.alrt_Success_Msg().getText();

		if (msg.contains("Status " + sName + " successfully created")) {
			Log.info("Verification Passed for Add Workflow Status.");
		} else {
			BaseClass.errorMsg = "Verification Failed for Add Workflow Status.";
			BaseClass.bResult = false;
		}
	}
	
	@AfterMethod
	public void afterMethod() throws Exception {

        driver.quit();
        Log.info("Browser closed");
        Log.endTestCase(sTestCaseName);
		TestLinkResultsManager.getInstance().writeToFile(sTestCaseName, BaseClass.bResult, BaseClass.errorMsg);
	}
}
