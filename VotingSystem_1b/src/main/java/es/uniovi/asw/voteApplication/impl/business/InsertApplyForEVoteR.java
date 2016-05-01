package es.uniovi.asw.voteApplication.impl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;

@Component
public class InsertApplyForEVoteR {

	@Autowired
	private UserDAO ud;
	@Autowired
	private TelematicVoterDAO td;

	
	public void saveApplication(String email, String password,
			ConfigurationElection configurationElection) throws InvalidUserException {
		
		User user = ud.findByMailAndContrasena(email, password);
		
		if(user == null){
			throw new InvalidUserException("Correo electronico y/o contraseña incorrectos");
		}
		
		if(td.findByUserAndConfigurationElection(user, configurationElection) != null){
			throw new InvalidUserException("Ya solicito el voto tematico");
		}

		TelematicVoter telematic = new TelematicVoter(user, false, configurationElection);
		td.save(telematic);

	}
	
}
