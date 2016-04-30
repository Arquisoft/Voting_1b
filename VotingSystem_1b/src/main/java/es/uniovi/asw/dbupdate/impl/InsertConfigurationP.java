package es.uniovi.asw.dbupdate.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.InsertConfiguration;
import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;

@Component
public class InsertConfigurationP implements InsertConfiguration {

	@Autowired(required=true)
	private ConfigurationDAO dao;
	
	@Override
	public void saveConfiguration(ConfigurationElection config)throws PersistenceException {
		try{
			dao.save(config);
		}catch(PersistenceException e){
			throw new PersistenceException("Error al crear la configuración",e);
		}
		
	}

}
