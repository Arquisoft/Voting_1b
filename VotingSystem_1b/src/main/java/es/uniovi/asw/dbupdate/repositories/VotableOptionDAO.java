package es.uniovi.asw.dbupdate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

@Repository
public interface VotableOptionDAO  extends CrudRepository<VotableOption, Long> { 
	
	public List<VotableOption> findByConfigurationElection(ConfigurationElection configurationElection); 
	  
}
