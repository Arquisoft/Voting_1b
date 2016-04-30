package es.uniovi.asw.voterVote.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voterVote.ListElection;
import es.uniovi.asw.voterVote.impl.bussiness.GetElectionListR;


public class ListElectionP implements ListElection{
	
	private List<ConfigurationElection> list;
	private ConfigurationElection configurationElection;

	public List<ConfigurationElection> getList() {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		GetElectionListR vs = ctx.getBean(GetElectionListR.class);
		
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
