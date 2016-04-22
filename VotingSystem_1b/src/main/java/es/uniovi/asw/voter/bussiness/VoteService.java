package es.uniovi.asw.voter.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;

@Component
public class VoteService {
	
	@Autowired
	private ConfigurationDAO cd;
	
	public List<ConfigurationElection> getElections(){
		List<ConfigurationElection> list = cd.findAll();
		return list;
	}

}
