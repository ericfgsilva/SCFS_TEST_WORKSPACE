package pageObjects.AutoCadastro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.General.BaseClass;
import util.Log;
import java.util.List;

public class AutoCadastro_Page extends BaseClass{

	private static WebElement element;
	private static List<WebElement> lineElement;

	public AutoCadastro_Page(WebDriver driver){
		super(driver);
	}

	public static WebElement div_TituloPagina() throws Exception{
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

	public static WebElement alert_CategoriaObrigatoria() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("lblCategoria"));
			Log.info("Asterisco de obrigatoriedade de categoria encontrado.");
		}catch (Exception e){
			Log.error("Asterisco de obrigatoriedade de categoria não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement list_Categorias(char categoria) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("ddlCategoria"));
            element.getAttribute("value").equals("categoria");
			Log.info("Categoria "+ categoria +" encontrada na lista");
		} catch (Exception e) {
			Log.error("Categoria "+categoria+" não encontrada na lista");
			throw (e);
		}
		return element;
	}

    public static WebElement txtbx_Cpf() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.id("txtAutenticarCPF"));
            Log.info("Campo CPF encontrado.");
        } catch (Exception e) {
            Log.error("Campo CPF não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_Matricula() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.id("txtAutenticarMatricula"));
            Log.info("Campo Matrícula encontrado.");
        } catch (Exception e) {
            Log.error("Campo Matrícula não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_DataNascimento() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.id("txtAutenticarDataNascimento"));
            Log.info("Campo Data de Nascimento encontrado.");
        } catch (Exception e) {
            Log.error("Campo Data de Nascimento não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement btn_Autenticar() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.id("btnAutenticar"));
            Log.info("Botão Autenticar encontrado.");
        } catch (Exception e) {
            Log.error("Botão Autenticar não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement btn_Cancelar() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.id("btnVoltar"));
            Log.info("Botão Cancelar encontrado.");
        } catch (Exception e) {
            Log.error("Botão Cancelar não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement alert_TituloAlerta() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.className("ja_title"));
            Log.info("Título da caixa de alerta encontrado.");
        } catch (Exception e) {
            Log.error("Título da caixa de alerta não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement alert_CorpoAlerta() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.className("ja_body"));
            Log.info("Corpo da caixa de alerta encontrado.");
        } catch (Exception e) {
            Log.error("Corpo da caixa de alerta não encontrado.");
            throw (e);
        }
        return element;
    }

    public static WebElement alert_BotaoAlertaOk() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.className("ja_body"));
            element.findElement(By.className("ja_btn_wrap optBack"));
            element.findElement(By.tagName("a"));
            Log.info("Botão OK do alerta encontrado.");
        } catch (Exception e) {
            Log.error("Botão OK do alerta não encontrado.");
            throw (e);
        }
        return element;
    }



    

}
