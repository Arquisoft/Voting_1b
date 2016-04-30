package es.uniovi.asw.voterVote.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.dbupdate.InsertVote;
import es.uniovi.asw.dbupdate.getVotationOptions;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

public class getVotationOptionsR {
	@Autowired
	getVotationOptions vd;

	
	
	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection){
		List<VotableOption> votableOptions = vd.findByConfigurationElection(configurationElection);
		
		return votableOptions;
	}
}
