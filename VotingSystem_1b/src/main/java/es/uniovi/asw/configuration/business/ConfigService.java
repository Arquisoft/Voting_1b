package es.uniovi.asw.configuration.business;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

public interface ConfigService {

	void saveConfiguration(ConfigurationElection config) throws PersistenceException;
}
