package es.uniovi.asw.dbupdate;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

public interface InsertConfiguration {

	void saveConfiguration(ConfigurationElection config) throws PersistenceException;
}
