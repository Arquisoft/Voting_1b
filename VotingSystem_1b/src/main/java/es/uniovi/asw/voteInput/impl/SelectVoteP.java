package es.uniovi.asw.voteInput.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.validator.impl.bussiness.CheckUserR;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voteInput.SelectVote;
import es.uniovi.asw.voteInput.impl.bussiness.LoadVoteR;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public class SelectVoteP implements SelectVote {
	
		private List<Vote> votos;
		private ConfigurationElection configurationElection;
		private String email;
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		private String password;
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Vote> getVotes(ConfigurationElection configurationElection) {
			WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			LoadVoteR vvs = ctx.getBean(LoadVoteR.class);
			this.configurationElection = configurationElection;
			
			List<VotableOption> miLista=vvs.getVotableOptions(configurationElection);
			votos=new ArrayList<Vote>();
			Date d= new Date();
			for(VotableOption v: miLista){
				votos.add(new Vote(d, v, 0));
			}
			return votos;
		}
		
		public void loadVote(){
			boolean fail = false;
			WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			LoadVoteR vvs = ctx.getBean(LoadVoteR.class);
			CheckUserR v = ctx.getBean(CheckUserR.class);
			
			try {
				
				for(int i=0;i<votos.size();i++){
					if(votos.get(i).getCantidad()<0){
						throw new BusinessException("Hay algun voto negativo en la lista de opciones");
					}
					
				}
			
				
			for(int i=0;i<votos.size();i++){
				v.validar(email, password);
				vvs.loadVoteForOption(configurationElection, votos.get(i));
				
				
			}
			
			
			} catch ( BusinessException | InvalidUserException
					e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage());
		        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
		        fail=true;
			}
			if(!fail){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Carga de votos correcta");
		        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
			}
		}

	}


