package es.uniovi.asw.dbupdate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.GetElectionList;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;

@Component
public class GetElectionP implements GetElectionList {
	
	@Autowired
	private ConfigurationDAO cd;
	
	public List<ConfigurationElection> getElections(){
		List<ConfigurationElection> list = cd.findAll();
		return list;
	}


}
