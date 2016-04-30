package es.uniovi.asw.voterVote.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voterVote.getVotationOptions;
import es.uniovi.asw.voterVote.impl.bussiness.VoteService;


public class MeterEnArquitectura {
	
	private List<ConfigurationElection> list;
	private ConfigurationElection configurationElection;

	public List<ConfigurationElection> getList() {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		VoteService vs = ctx.getBean(VoteService.class);
		
		list = vs.getElections();
		return list;
	}

	public ConfigurationElection getConfigurationElection() {
		return configurationElection;
	}

	public void setConfigurationElection(ConfigurationElection configurationElection) {
		this.configurationElection = configurationElection;
	}

}
