package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import es.uniovi.asw.util.SeleniumUtils;

public class CargaVotosInput {

	private WebDriver driver = SeleniumUtils.getDriver("VoteApplication");
	
	@Cuando("^Entra en la web$")
	public void entra_en_la_web() throws Throwable {
		driver.get("http://localhost:8080/admin/index.xhtml");
	}
	
	@Cuando("^entra en la web de administracion$")
	public void entra_en_la_web_again() throws Throwable {
		driver.get("http://localhost:8080/admin/index.xhtml");
	}


	@Entonces("^se valida con la cuenta \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void se_valida_con_la_cuenta_y_password(String arg1, String arg2) throws Throwable {
		WebElement elemento2 = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento2.sendKeys(arg1);
		elemento2 = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento2.sendKeys(arg2);
		elemento2 = driver.findElement(By.className("solicitar"));
		elemento2.click();
	}

	@Entonces("^se valida de nuevo con la cuenta \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void se_valida_de_nuevo_con_la_cuenta_y_password(String arg1, String arg2) throws Throwable {
		WebElement elemento2 = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento2.sendKeys(arg1);
		elemento2 = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento2.sendKeys(arg2);
		elemento2 = driver.findElement(By.className("solicitar"));
		elemento2.click();
	}

	@Entonces("^se valida incorrectamente con la cuenta \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void se_valida_incorrectamente_con_la_cuenta_y_password(String arg1, String arg2) throws Throwable {
		WebElement elemento2 = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento2.sendKeys(arg1);
		elemento2 = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento2.sendKeys(arg2);
		elemento2 = driver.findElement(By.className("solicitar"));
		elemento2.click();
	}
	
	@Entonces("^se me muestra el mensaje \"([^\"]*)\" por login malo$")
	public void se_me_muestra_el_mensaje_por_login_malo(String arg1) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", arg1, 2);
	    
	    SeleniumUtils.finishTest(driver);
	}
	
	@Entonces("^Va a la zona de votaciones para gestionar$")
	public void va_a_la_zona_de_votaciones_para_gestionar() throws Throwable {
	
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "gestion", 2); 
		elementos.get(0).click();
	}

	@Entonces("^Va a la zona de votaciones para gestionar de nuevo parasi gestionar una votacion que quiere$")
	public void va_a_la_zona_de_votaciones_para_gestionar_de_nuevo_parasi_gestionar_una_votacion_que_quiere() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "gestion", 2); 
		elementos.get(0).click();
	}
	
	@Cuando("^entra en la web de nuevo$")
	public void entra_en_la_web_de_nuevo() throws Throwable {
		driver.get("http://localhost:8080/admin/index.xhtml");
	}
	
	@Entonces("^decide gestionar una votacion que quiere$")
	public void decide_gestionar_una_votacion_que_quiere() throws Throwable {
		//ya hecho?
	}

	@Entonces("^introduciendo todos los votos y la cuenta \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void introduciendo_todos_los_votos_y_la_cuenta_y_password(String arg1, String arg2) throws Throwable {
		WebElement elemento = driver.findElement(By.className("miClaseParaSelenium"));
		elemento.click();
		WebElement elemento2 = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento2.sendKeys(arg1);
		elemento2 = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento2.sendKeys(arg2);
		elemento2 = driver.findElement(By.id("form-cuerpo:confirmar-voto"));
		elemento2.click();
	}
	
	

	@Entonces("^se le muestra el mensaje \"([^\"]*)\" en voteInput$")
	public void se_le_muestra_el_mensaje_en_voteInput(String arg1) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", arg1, 2);
	    
	    SeleniumUtils.finishTest(driver);
	}

	@Entonces("^se le muestra el mensaje \"([^\"]*)\"  al no ser admin$")
	public void se_le_muestra_el_mensaje_al_no_ser_admin(String arg1) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", arg1, 2);
	    
	    SeleniumUtils.finishTest(driver);
	}



	
}
