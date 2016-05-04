package es.uniovi.asw.configuration.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;

@Component
public class InsertConfigurationR {
	
	@Autowired
	private ConfigurationDAO cd;
	@Autowired
	private VotableOptionDAO vd;
	
	public void saveConfiguration(ConfigurationElection config)throws PersistenceException {
		try{
			cd.save(config);
		}catch(PersistenceException e){
			throw new PersistenceException("Error al crear la configuración",e);
		}
		
	}
	
	public void saveVotableOption(List<VotableOption> vo)throws PersistenceException {
		try{
			for(VotableOption i:vo)
				vd.save(i);
		}catch(PersistenceException e){
			throw new PersistenceException("Error al guardar las opciones de voto",e);
		}
		
	}
	
}
