package es.uniovi.asw.voterVote.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.InsertVote;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.AlredyVotedException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public class InsertVoteR {
	@Autowired
	InsertVote vd;

	
	
	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection){
		List<VotableOption> votableOptions = vd.findByConfigurationElection(configurationElection);
		
		return votableOptions;
	}
	
	public void voteOnElection(ConfigurationElection c, Vote v, String email, String password) throws InvalidUserException, BusinessException, AlredyVotedException {
	
		User user = vd.findByMailAndContrasena(email, password);

		if(user == null){
			throw new InvalidUserException("Usuario incorrecto.");
		}
		
		TelematicVoter miVotoTelematico=vd.findByUserAndConfigurationElection(user, c);
		v.setColegio(user.getCodigoColegio());
		
		if(miVotoTelematico == null){
			throw new BusinessException("No habias pedido voto telematico.");
		}
		
		if(miVotoTelematico.isVoted()){
			throw new AlredyVotedException("Ya has votado en esta votacion.");
		}
		
		miVotoTelematico.setVoted(true);
		vd.save(miVotoTelematico);
		
		vd.save(v);
		
	}


}
