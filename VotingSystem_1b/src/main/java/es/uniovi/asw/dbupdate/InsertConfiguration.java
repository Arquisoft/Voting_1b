package es.uniovi.asw.dbupdate;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

public interface InsertConfiguration {
//magia
	void saveConfiguration(ConfigurationElection config) throws PersistenceException;
}
