package es.uniovi.asw.voter.application.bussiness;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

public interface ApplicationService {
	
	public void saveApplication(String email, String password, ConfigurationElection configurationElection) throws InvalidUserException;	
	
}
