package es.uniovi.asw.voterVote.impl.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.AlredyVotedException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public class InsertVoteR {
	
	@Autowired
	private UserDAO ud;
	@Autowired
	private TelematicVoterDAO td;
	@Autowired
	private VoteDAO vD;
	
	public void voteOnElection(ConfigurationElection c, Vote v, String email, String password) throws InvalidUserException, BusinessException, AlredyVotedException {
	
		User user = ud.findByMailAndContrasena(email, password);

		if(user == null){
			throw new InvalidUserException("Usuario incorrecto.");
		}
		
		TelematicVoter miVotoTelematico=td.findByUserAndConfigurationElection(user, c);
		v.setColegio(user.getCodigoColegio());
		
		if(miVotoTelematico == null){
			throw new BusinessException("No habias pedido voto telematico.");
		}
		
		if(miVotoTelematico.isVoted()){
			throw new AlredyVotedException("Ya has votado en esta votacion.");
		}
		
		miVotoTelematico.setVoted(true);
		td.save(miVotoTelematico);
		
		vD.save(v);
		
	}


}
