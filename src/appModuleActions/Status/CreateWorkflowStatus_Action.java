package appModuleActions.Status;

import org.openqa.selenium.WebDriver;
import pageObjects.Status.StatusCreate_Modal;
import pageObjects.Status.StatusList_Page;
import pageObjects.General.Home_Page;
import util.Constants;
import util.ExcelUtils;
import util.Log;
import util.Utils;

public class CreateWorkflowStatus_Action {

	public static String Execute(WebDriver driver, int iTestCaseRow, boolean isRandom) throws Exception {

		String random = "";
		if (isRandom) {
			random = Utils.generateRandomNumber();
		}
		ExcelUtils.setCellData(random, iTestCaseRow, Constants.Col_Generic_2);

        String sName = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Generic_1);
        sName = sName + random;
        Log.info("Name picked from Excel is " + sName);

		Home_Page.link_Tasks().click();

		Log.info("Click action performed on Tasks link.");

        Thread.sleep(10);

		//Home_Page.link_Tasks_Status().click();
		Home_Page.link_Tasks_Status().click();
		Log.info("Click action performed on Status link");
		
		if (StatusList_Page.btn_Add() != null) {
			StatusList_Page.btn_Add().click();
			Log.info("Click action performed on Add button");

			StatusCreate_Modal.txtbx_Name().click();
			StatusCreate_Modal.txtbx_Name().clear();
			StatusCreate_Modal.txtbx_Name().sendKeys(sName);
			Log.info("Name entered in the name text box");

			Thread.sleep(10);

			StatusCreate_Modal.btn_Create().click();
			Log.info("Click action performed on Create button");
		} else {
			Log.info("Add button not is Displayed");
		}
		return sName;
	}
}
