package pageObjects.General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Log;

public class Home_Page extends BaseClass {

	private static WebElement element;

	public Home_Page(WebDriver driver){
		super(driver);
	}

	public static WebElement link_Logo() throws Exception{
		
		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/a/span[2]"));
			Log.info("Logo link found");
		}catch (Exception e){

			Log.error("Logo link not found");
			throw(e);
		}

		return element;
	}
	
//	public static WebElement link_UserPreferences() throws Exception{
//
//		element = null;
//		try{
//
//			element = driver.findElement(By.id("preferences"));
//			Log.info("Logged User link found");
//		}catch (Exception e){
//
//			Log.error("Logged User link not found");
//			throw(e);
//		}
//
//		return element;
//	}
	
//	public static WebElement link_SystemConfigurations() throws Exception{
//
//		element = null;
//		try{
//
//			element = driver.findElement(By.id("settings"));
//			Log.info("System Configurations link found");
//		}catch (Exception e){
//
//			Log.error("System Configurations link not found");
//			throw(e);
//		}
//
//		return element;
//	}
	
//	public static WebElement link_Help() throws Exception{
//
//		element = null;
//		try{
//
//			element = driver.findElement(By.id("help"));
//			Log.info("Help link found");
//		}catch (Exception e){
//
//			Log.error("Help link not found");
//			throw(e);
//		}
//
//		return element;
//	}
	
	public static WebElement link_LogOut() throws Exception{
		
		element = null;
		try{

			element = driver.findElement(By.id("logout"));
			Log.info("Logout link found");
		}catch (Exception e){

			Log.error("Logout link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Tasks() throws Exception{
		
		element = null;
		try{
			element = driver.findElement(By.id("tasks-dropdown"));
			Log.info("Tasks menu link found");
		}catch (Exception e){
			Log.error("Tasks menu link not found");
			throw(e);
		}
		return element;
	}

	public static WebElement link_Tasks_List() throws Exception{
		
		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[1]/ul/li[1]/a"));
			Log.info("List link found");
		}catch (Exception e){

			Log.error("List link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Tasks_Workflows() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[1]/ul/li[2]/a"));
			Log.info("Workflows link found");
		}catch (Exception e){

			Log.error("Workflows link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Tasks_Status() throws Exception{

		element = null;
		try{
			element = driver.findElement(By.id("status-list"));
			Log.info("Status link found");
		}catch (Exception e){
			Log.error("Status link not found");
			throw(e);
		}
		return element;
	}

	public static WebElement link_Users() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[2]/a"));
			Log.info("Users link found");
		}catch (Exception e){

			Log.error("Users link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Users_List() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[2]/ul/li[1]/a"));
			Log.info("List link found");
		}catch (Exception e){

			Log.error("List link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Users_Roles() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[2]/ul/li[2]/a"));
			Log.info("Roles link found");
		}catch (Exception e){

			Log.error("Roles link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Users_Groups() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[2]/ul/li[3]/a"));
			Log.info("Groups link found");
		}catch (Exception e){

			Log.error("Groups link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Users_NotSubscribers() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[2]/ul/li[4]/a"));
			Log.info("Notifications Subscribers link found");
		}catch (Exception e){

			Log.error("Notifications Subscribers link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Users_NotGroups() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/ul/li[2]/ul/li[5]/a"));
			Log.info("Notifications Groups link found");
		}catch (Exception e){

			Log.error("Notifications Groups link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Vendors() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.id("vendors-dropdown"));
			Log.info("Vendors link found");
		}catch (Exception e){

			Log.error("Vendors link not found");
			throw(e);
		}

		return element;
	}

	public static WebElement link_Vendors_List() throws Exception{

		element = null;
		try{

			element = driver.findElement(By.id("vendors-list"));
			Log.info("Vendors List link found");
		}catch (Exception e){

			Log.error("Vendors List link not found");
			throw(e);
		}

		return element;
	}
}
