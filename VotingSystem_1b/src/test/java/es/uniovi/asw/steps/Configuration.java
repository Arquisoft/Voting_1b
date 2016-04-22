package es.uniovi.asw.steps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import es.uniovi.asw.CucumberTest;
import es.uniovi.asw.Main;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.util.SeleniumUtils;

@ContextConfiguration(classes=Main.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class Configuration {

	private WebDriver driver = SeleniumUtils.getDriver("Configuration");
	
	@Cuando("^entra en /admin/configuration\\.xhtml$")
	public void entra_en_admin_configuration_xhtml() throws Throwable {
		driver.get("http://localhost:8080/admin/configuration.xhtml");
	}

	@Entonces("^se ven las opciones disponibles$")
	public void se_ven_las_opciones_disponibles() throws Throwable {
		SeleniumUtils.esperaCargaPaginaNoTexto(driver, "nombre", 2);
	}

	@Entonces("^elige las opciones dejando campos vacios y hace click en validar$")
	public void elige_las_opciones_dejando_campos_vacios_y_hace_click_en_validar() throws Throwable {
		WebElement elemento = driver.findElement(By.id("input_form-cuerpo:nombre"));
		elemento.sendKeys("Nombre");
		elemento = driver.findElement(By.id("form-cuerpo:botonValidar"));
		elemento.click();
	}

	@Entonces("^se le muestra un mensaje que indica que debe cubrir todos los campos$")
	public void se_le_muestra_un_mensaje_que_indica_que_debe_cubrir_todos_los_campos() throws Throwable {
		//SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "form-cuerpo:j_idt16", 9);
		//SeleniumUtils.textoPresentePagina(driver, "Debe indicar una fecha de inicio");
		SeleniumUtils.finishTest(driver);
	}


}
