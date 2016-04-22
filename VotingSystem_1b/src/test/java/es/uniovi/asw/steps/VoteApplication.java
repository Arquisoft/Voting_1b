package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import es.uniovi.asw.Main;
import es.uniovi.asw.util.SeleniumUtils;

@ContextConfiguration(classes=Main.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class VoteApplication {

	private WebDriver driver = SeleniumUtils.getDriver("VoteApplication");
	
	@Cuando("^entra en la web$")
	public void entra_en() throws Throwable {
		driver.get("http://localhost:8080/");
	}

	@Entonces("^se ve la lista de las votaciones disponibles$")
	public void se_ve_la_lista_de_las_votaciones_disponibles() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Ir a realizar la solicitud", 2); 
	}

	@Y("^decide la votacion y hace click en solicitar$")
	public void decide_la_votacion_y_hace_click_en_solicitar() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "apply", 2); 
		elementos.get(0).click();
	}

	@Entonces("^se le piden sus datos para solicitar el voto telematico$")
	public void se_le_piden_sus_datos_correctos_para_finalizar_la_votacion() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "VoteApplication", 2); 
	}

	@Entonces("^introduce su email \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void introduce_su_email_y_password(String email, String password) throws Throwable {
		WebElement elemento = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento.sendKeys(email);
		elemento = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento.sendKeys(password);
		elemento = driver.findElement(By.id("form-cuerpo:solicitar"));
		elemento.click();
	}
	
	@Entonces("^se le muestra el mensaje \"([^\"]*)\" referente al voto telematico$")
	public void se_le_muestra_el_mensaje_referente_al_voto_telematico(String mensaje) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", mensaje, 2); 
		SeleniumUtils.finishTest(driver);
	}

}
