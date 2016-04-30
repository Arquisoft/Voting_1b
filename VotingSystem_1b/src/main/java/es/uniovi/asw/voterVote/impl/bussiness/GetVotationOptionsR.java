package es.uniovi.asw.voterVote.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.dbupdate.InsertVote;
import es.uniovi.asw.dbupdate.GetVotationOptions;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

public class GetVotationOptionsR {
	@Autowired
	GetVotationOptions vd;

	
	
	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection){
		List<VotableOption> votableOptions = vd.findByConfigurationElection(configurationElection);
		
		return votableOptions;
	}
}
