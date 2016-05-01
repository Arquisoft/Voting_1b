package es.uniovi.asw.voteApplication.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voteApplication.ApplyForEVote;
import es.uniovi.asw.voteApplication.impl.business.InsertApplyForEVoteR;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;

@Component
public class ApplyForEVoteP implements ApplyForEVote{
	
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
		InsertApplyForEVoteR sas = ctx.getBean(InsertApplyForEVoteR.class);
		
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
