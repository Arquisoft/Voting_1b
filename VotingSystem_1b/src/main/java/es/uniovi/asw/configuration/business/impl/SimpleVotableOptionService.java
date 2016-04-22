package es.uniovi.asw.configuration.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.configuration.business.VotableOptionService;
import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;

@Component
public class SimpleVotableOptionService implements VotableOptionService {

	@Autowired(required=true)
	private VotableOptionDAO dao;
	
	@Override
	public void saveVotableOption(List<VotableOption> vo)throws PersistenceException {
		try{
			for(VotableOption i:vo)
				dao.save(i);
		}catch(PersistenceException e){
			throw new PersistenceException("Error al guardar las opciones de voto",e);
		}
		
	}

}
