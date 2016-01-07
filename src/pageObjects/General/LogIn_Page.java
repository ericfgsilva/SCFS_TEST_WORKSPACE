package pageObjects.General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Log;

public class LogIn_Page extends BaseClass{

	private static WebElement element;

	public LogIn_Page(WebDriver driver){
		super(driver);
	}

	public static WebElement div_LogoLogin() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("divLogoLogin"));
			Log.info("Logomarca da página de login do sistema encontrada.");
		}catch (Exception e){
			Log.error("Logomarca da página de login do sistema não encontrada.");
			throw(e);
		}
		return element;
	}

	public static WebElement txtbx_Usuario() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_UserName"));
			Log.info("Campo usuário encontrado.");
		}catch (Exception e){
			Log.error("Campo usuário não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement alert_UsuarioObrigatorio() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_UserNameRequired"));
			Log.info("Asterisco de alerta do campo usuário encontrado.");
		}catch (Exception e){
			Log.error("Asterisco de alerta do campo usuário não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement txtbx_Senha() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_Password"));
			Log.info("Campo senha encontrado.");
		}catch (Exception e){
			Log.error("Campo senha não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement alert_SenhaObrigatoria() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_PasswordRequired"));
			Log.info("Asterisco de alerta do campo senha encontrado.");
		}catch (Exception e){
			Log.error("Asterisco de alerta do campo senha não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement btn_Entrar() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_LoginButton"));
			Log.info("Botão entrar encontrado.");
		}catch (Exception e){
			Log.error("Botão entrar não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement link_CadastreSe() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_lblAutoCadastro"));
			Log.info("Link cadastre-se encontrado.");
		}catch (Exception e){
			Log.error("Link cadastre-se não encontrado.");
			throw(e);
		}
		return element;
	}

	public static WebElement link_EsqueciSenha() throws Exception{
		element = null;
		try{
			element = driver.findElement(By.id("Login1_lblEsqueciMinhaSenha"));
			Log.info("Link esqueci minha senha encontrado.");
		}catch (Exception e){
			Log.error("Link esqueci minha senha não encontrado.");
			throw(e);
		}
		return element;
	}

}
