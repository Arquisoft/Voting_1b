package es.uniovi.asw.voteInput.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public class LoadVoteR {
	
	@Autowired
	VotableOptionDAO vd;
	@Autowired
	private UserDAO ud;
	@Autowired
	private VoteDAO votoDao;
	
	public void loadVoteForOption(ConfigurationElection c, Vote v, String email, String password) throws BusinessException, InvalidUserException{
		
		User user = ud.findByMailAndContrasena(email, password);

		if(user == null || !user.isAdmin()){
			throw new InvalidUserException("Usuario incorrecto.");
		}
		
		votoDao.save(v);
	
	}

	public List<VotableOption> getVotableOptions(
			ConfigurationElection configurationElection) {
		return vd.findByConfigurationElection(configurationElection);
	}
}
