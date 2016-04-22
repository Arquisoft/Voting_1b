package es.uniovi.asw.voter.vote.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voter.application.exception.InvalidUserException;
import es.uniovi.asw.voter.vote.exception.BusinessException;

@Component
public class VoteInputService {
	@Autowired
	VotableOptionDAO vd;
	
	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;
	@Autowired(required=true)
	private VoteDAO votoDao;
	
	public void loadVoteForOption(ConfigurationElection c, Vote v, String email, String password) throws BusinessException, InvalidUserException{
		
		User user = ud.findByMailAndContrasena(email, password);

		if(user == null || !user.isAdmin()){
			throw new InvalidUserException("Usuario incorrecto.");
		}
		
		votoDao.save(v);
		
	}
}
