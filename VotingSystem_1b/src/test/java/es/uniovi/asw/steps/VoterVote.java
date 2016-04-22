package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import es.uniovi.asw.util.SeleniumUtils;

public class VoterVote {
	
	private WebDriver driver = SeleniumUtils.getDriver("VoterVote");
	
	@Cuando("^entra en / para votar$")
	public void entra_en_para_votar() throws Throwable {
		driver.get("http://localhost:8080/");
	}

	@Entonces("^se ve la lista de las votaciones disponibles para votar$")
	public void se_ve_la_lista_de_las_votaciones_disponibles_para_votar() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Ir a votar", 2); 
	}

	@Entonces("^decide la votacion y hace click$")
	public void decide_la_votacion_y_hace_click() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "vote", 2); 
		elementos.get(0).click();
	}

	@Entonces("^se le muestrarn las opciones disponibles$")
	public void se_le_muestrarn_las_opciones_disponibles() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "PP", 2); 
		SeleniumUtils.esperaCargaPagina(driver, "text", "PSOE", 2); 
		SeleniumUtils.esperaCargaPagina(driver, "text", "Cs", 2); 
		SeleniumUtils.esperaCargaPagina(driver, "text", "Podemos", 2); 
	}
	
	@Entonces("^elige la opcion que quiere votar la (\\d+)$")
	public void elige_la_opcion_que_quiere_votar_la(int arg1) throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "votar", 5);
		elementos.get(arg1 - 1).click();
	}
	
	@Entonces("^introduce su email \"([^\"]*)\" y password \"([^\"]*)\" para votar$")
	public void introduce_su_email_y_contraseña(String email, String password) throws Throwable {
		WebElement elemento = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento.sendKeys(email);
		elemento = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento.sendKeys(password);
		elemento = driver.findElement(By.id("form-cuerpo:confirmar-voto"));
		elemento.click();
	}

	@Entonces("^le piden los datos para confirmar el voto$")
	public void le_piden_los_datos_para_confirmar_el_voto() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Introduce tus datos", 2);
	}

	@Entonces("^se le muestra el mensaje \"([^\"]*)\"$")
	public void se_le_muestra_el_mensaje(String mensaje) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", mensaje, 2);
		SeleniumUtils.finishTest(driver);
	}
}
