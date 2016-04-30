package es.uniovi.asw.voteApplication.impl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.InserApplyForEVote;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;

@Component
public class InsertApplyForEVoteR {

	@Autowired
	private InserApplyForEVote ia;
	
	public void saveApplication(String email, String password,
			ConfigurationElection configurationElection) throws InvalidUserException {
		

		User user = ia.geUserInfo(email, password);
		
		if(ia.alreadyTelematicVoter(user, configurationElection)){
			throw new InvalidUserException("Ya solicito el voto tematico");
		}

		if(user == null){
			throw new InvalidUserException("Correo electronico y/o contraseña incorrectos");
		}

		TelematicVoter telematic = new TelematicVoter(user, false, configurationElection);
		ia.insertTelematicVoter(telematic);

	}
	
}
