package es.uniovi.asw.voteInput.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public class LoadVoteR {
	
	@Autowired
	VotableOptionDAO vd;
	@Autowired
	private VoteDAO votoDao;
	
	public void loadVoteForOption(ConfigurationElection c, Vote v) throws BusinessException, InvalidUserException{
		
		votoDao.save(v);
	
	}

	public List<VotableOption> getVotableOptions(
			ConfigurationElection configurationElection) {
		return vd.findByConfigurationElection(configurationElection);
	}
}
