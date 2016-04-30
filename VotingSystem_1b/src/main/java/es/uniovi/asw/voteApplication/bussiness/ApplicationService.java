package es.uniovi.asw.voteApplication.bussiness;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voteApplication.exception.InvalidUserException;

public interface ApplicationService {
	
	public void saveApplication(String email, String password, ConfigurationElection configurationElection) throws InvalidUserException;	
	
}
