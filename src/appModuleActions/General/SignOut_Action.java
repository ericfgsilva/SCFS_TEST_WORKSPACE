//package appModuleActions;
//
//import org.openqa.selenium.WebDriver;
//import pageObjects.General.Home_Page;
//import util.Log;
//
//public class SignOut_Action {
//
//	public static String Execute(WebDriver driver, int iTestCaseRow) throws Exception{
//
//		String userLogged = Home_Page.link_UserPreferences().getText();
//		Log.info("Get Username on Preference user link");
//
//		Home_Page.link_LogOut().click();
//		Log.info("Click action performed on LogOut button");
//
//		return userLogged;
//	}
//
//}
