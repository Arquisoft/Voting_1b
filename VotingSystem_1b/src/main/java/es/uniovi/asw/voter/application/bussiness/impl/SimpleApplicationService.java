package es.uniovi.asw.voter.application.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voter.application.bussiness.ApplicationService;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

@Component
public class SimpleApplicationService implements ApplicationService {

	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;
	
	@Autowired(required=true)
	private VoteDAO votoDao;

	@Override
	public void saveApplication(String email, String password,
			ConfigurationElection configurationElection) throws InvalidUserException {
		

		User user = ud.findByMailAndContrasena(email, password);
		
		if(td.findByUserAndConfigurationElection(user, configurationElection) != null){
			throw new InvalidUserException("Ya solicito el voto tematico");
		}

		if(user == null){
			throw new InvalidUserException("Correo electronico y/o contraseña incorrectos");
		}

		TelematicVoter telematic = new TelematicVoter(user, false, configurationElection);
		td.save(telematic);

	}
	
}
