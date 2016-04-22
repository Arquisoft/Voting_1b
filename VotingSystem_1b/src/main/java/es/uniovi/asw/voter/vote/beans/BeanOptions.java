package es.uniovi.asw.voter.vote.beans;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voter.application.exception.InvalidUserException;
import es.uniovi.asw.voter.vote.bussiness.VoterVoteService;
import es.uniovi.asw.voter.vote.exception.AlredyVotedException;
import es.uniovi.asw.voter.vote.exception.BusinessException;

public class BeanOptions {
	
	private VotableOption selectOption;
	private ConfigurationElection configurationElection;
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
	public VotableOption getSelectOption() {
		return selectOption;
	}

	public void setSelectOption(VotableOption selectOption) {
		this.selectOption = selectOption;
	}

	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection) {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		VoterVoteService vvs = ctx.getBean(VoterVoteService.class);
		this.configurationElection = configurationElection;
		
		return vvs.getVotableOptions(configurationElection);
	}
	
	public void vote(){
		boolean fail = false;
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		VoterVoteService vvs = ctx.getBean(VoterVoteService.class);
		
		try {
			vvs.voteOnElection(configurationElection, new Vote(new Date(), selectOption, 1), email, password);
		} catch (InvalidUserException | BusinessException
				| AlredyVotedException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
	        fail=true;
		}
		if(!fail){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Ha votado correctamente");
	        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
		}
	}

}
