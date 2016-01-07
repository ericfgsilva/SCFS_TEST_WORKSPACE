package pageObjects.General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Log;

import java.util.List;

public class EsqueciMinhaSenha_Page extends BaseClass{

	private static WebElement element;
	private static List<WebElement> lineElement;

	public EsqueciMinhaSenha_Page(WebDriver driver){
		super(driver);
	}

	public static WebElement txtbx_Login() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("txtLogin"));
			Log.info("Campo de Login encontrado.");
		}catch (Exception e){
			Log.error("Campo de Login não encontrado.");
			throw(e);
		}
		return element;
	}

    public static WebElement lbl_TituloPagina() throws Exception{
        element = null;
        try{
            element = driver.findElement(By.className("legendTituloPagina"));
            Log.info("Título da página encontrado.");
        }catch (Exception e){
            Log.error("Título da página não encontrado.");
            throw(e);
        }
        return element;
    }



    

}
