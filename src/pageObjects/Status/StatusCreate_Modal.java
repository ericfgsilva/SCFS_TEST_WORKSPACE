package pageObjects.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.General.BaseClass;
import util.Log;

public class StatusCreate_Modal extends BaseClass {
	
	private static WebElement element;
	
	public StatusCreate_Modal(WebDriver driver){
		super(driver);
	}


        public static WebElement alrt_ErrorMsg_Edit() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("pnl-edit-errors"));
                Log.info("Error alert found");
            } catch (Exception e) {
                Log.error("Error alert not found");
                throw (e);
            }
            return element;
        }

        public static WebElement alrt_ErrorMsg_Create() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("pnl-create-errors"));
                Log.info("Error alert found");
            } catch (Exception e) {
                Log.error("Error alert not found");
                throw (e);
            }
            return element;
        }

        public static WebElement btn_AlrtErrorDismiss() throws Exception {

            element = null;
            try {
                element = driver.findElement(By.id("entity-create-errors-dismiss"));
                Log.info("Button alert found");
            } catch (Exception e) {
                Log.error("Button alert not found");
                throw (e);
            }
            return element;
        }

        public static WebElement label_AddNewStatus() throws Exception{

            element = null;
            try{
                element = driver.findElement(By.id("create-statusLabel"));
                Log.info("Label in Add New Status found");
            }catch (Exception e){
                Log.error("Label in Add New Status not found");
                throw(e);
            }
            return element;
        }

        public static WebElement txtbx_Name() throws Exception{

            element = null;
            try{
                element = driver.findElement(By.id("create-entity-name"));
                Log.info("Name text box in Add New Status found");
            }catch (Exception e){
                Log.error("Name text box in Add New Status not found");
                throw(e);
            }
            return element;
        }

        public static WebElement btn_Cancel() throws Exception{

            element = null;
            try{
                element = driver.findElement(By.id("bt-cancel-create-entity"));
                Log.info("Cancel button in Add New Status found");
            }catch (Exception e){
                Log.error("Cancel button in Add New Status not found");
                throw(e);
            }
            return element;
        }

        public static WebElement btn_Create() throws Exception{

            element = null;
            try{
                element = driver.findElement(By.id("bt-confirm-create-entity"));
                Log.info("Create button in Add New Status found");
            }catch (Exception e){
                Log.error("Add button in Add New Status not found");
                throw(e);
            }
            return element;
        }

	
}

