package pageObjects.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.General.BaseClass;
import util.Log;

import java.util.List;

public class StatusList_Page extends BaseClass {

	private static WebElement element;
	private static List<WebElement> lineElement;

	public StatusList_Page(WebDriver driver) {
		super(driver);
	}

        public static List<WebElement> line_Entity(int line) throws Exception {

            element = null;
            lineElement = null;
            try {
                element = driver.findElement(By.id("table-row-" + (line)));
                lineElement = element.findElements(By.tagName("td"));
                Log.info("Line Entity found");
            } catch (Exception e) {
                Log.error("Line Entity not found");
                throw (e);
            }
            return lineElement;
        }

        public static WebElement btn_Add() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("bt-create-entity"));
                Log.info("Add button found");
            } catch (Exception e) {
                Log.error("Add button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_RemoveAll() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("bt-remove-multiple"));
                Log.info("Remove All button found");
            } catch (Exception e) {
                Log.error("Remove All button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement txtbx_Search() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("search-input"));
                Log.info("Search text box found");
            } catch (Exception e) {
                Log.error("Search text box not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_Search() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("search-submit"));
                Log.info("Search button found");
            } catch (Exception e) {
                Log.error("Search button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_Confirm_RemoveAll() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("bt-confirm-remove-multiple"));
                Log.info("Confirm Remove All button found");
            } catch (Exception e) {
                Log.error("Confirm Remove All button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_Cancel_RemoveAll() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("bt-cancel-remove-multiple"));
                Log.info("Cancel Remove All button found");
            } catch (Exception e) {
                Log.error("Cancel Remove All button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_Confirm_RemoveLine() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("bt-confirm-remove-entity"));
                Log.info("Confirm Remove unit button found");
            } catch (Exception e) {
                Log.error("Confirm Remove unit button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_Cancel_RemoveLine() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("bt-cancel-remove-entity"));
                Log.info("Cancel Remove unit button found");
            } catch (Exception e) {
                Log.error("Cancel Remove unit button not found");
                throw (e);
            }
            return element;
        }

        public static WebElement alrt_Success_Msg() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("add_alert-success-message"));
                Log.info("Create Entity alert found");
            } catch (Exception e) {
                Log.error("Create Entity alert not found");
                throw (e);
            }
            return element;
        }

        public static WebElement alrt_CreatedFailed() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("pnl-create-errors"));
                Log.info("Create Entity alert error found");
            } catch (Exception e) {
                Log.error("Create Entity alert error not found");
                throw (e);
            }
            return element;
        }


        public static WebElement alrt_RemoveFailed() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("add_alert-danger-message"));
                Log.info("Failed remove entity alert found");
            } catch (Exception e) {
                Log.error("Failed remove entity alert not found");
                throw (e);
            }
            return element;
        }
	
	
}
