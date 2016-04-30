package es.uniovi.asw.voteInput.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.GetVotationOptions;
import es.uniovi.asw.dbupdate.InsertVote;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public class InsertVoteR {
	@Autowired
	GetVotationOptions vd;
	
	@Autowired
	InsertVote aaa;
	
	
	
	public void loadVoteForOption(ConfigurationElection c, Vote v, String email, String password) throws BusinessException, InvalidUserException{
		
		aaa.loadVoteForOption(c, v, email, password);
	
		
		
	}

	public List<VotableOption> getVotableOptions(
			ConfigurationElection configurationElection) {
		return vd.findByConfigurationElection(configurationElection);
	}
}
