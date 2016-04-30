package es.uniovi.asw.voteApplication.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voteApplication.bussiness.impl.SimpleApplicationService;
import es.uniovi.asw.voteApplication.exception.InvalidUserException;

@Component
public class BeanApplication {
	
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
	
	public void apply(ConfigurationElection configurationElection){
		boolean fail = false;
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleApplicationService sas = ctx.getBean(SimpleApplicationService.class);
		
		try {
			sas.saveApplication(email, password, configurationElection);
		} catch (InvalidUserException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
            fail = true;
		}
		if(!fail){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Voto telematico admitido");
	        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
		}
	}

}
