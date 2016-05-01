package es.uniovi.asw.validator.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.validator.Validate;
import es.uniovi.asw.validator.impl.bussiness.CheckUserR;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;

public class ValidateP implements Validate{
	
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
		return validar(this.email, this.password);
	}
	@Override
	public String validar(String email, String password) {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		CheckUserR vs = ctx.getBean(CheckUserR.class);
		
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
