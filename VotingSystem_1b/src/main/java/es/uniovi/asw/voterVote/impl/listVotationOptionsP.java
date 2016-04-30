package es.uniovi.asw.voterVote.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.voterVote.getVotationOptions;
import es.uniovi.asw.voterVote.impl.bussiness.InsertVoteR;

public class listVotationOptionsP implements getVotationOptions {

	@Override
	public List<VotableOption> getList(ConfigurationElection configurationElection) {
		
			WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			InsertVoteR vvs = ctx.getBean(InsertVoteR.class);
		
			return vvs.getVotableOptions(configurationElection);
		
	}

}
