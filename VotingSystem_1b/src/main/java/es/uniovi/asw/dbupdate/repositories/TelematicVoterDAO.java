package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;

@Repository
public interface TelematicVoterDAO extends CrudRepository<TelematicVoter, Long>{

	
	   public TelematicVoter findByUserAndConfigurationElection(User user, ConfigurationElection configurationElection);
	
	
	
}
