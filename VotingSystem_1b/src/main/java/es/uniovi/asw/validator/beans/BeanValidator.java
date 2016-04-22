package es.uniovi.asw.validator.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.validator.bussiness.ValidatorService;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

public class BeanValidator {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validar(){
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		ValidatorService vs = ctx.getBean(ValidatorService.class);
		
		try {
			vs.validar(email, password);
		} catch (InvalidUserException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
			return "fracaso";
		}
		
		return "exito";
	}

}
