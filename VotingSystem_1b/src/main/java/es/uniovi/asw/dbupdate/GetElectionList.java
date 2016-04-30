package es.uniovi.asw.dbupdate;

import java.util.List;

import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;

@Component
public interface GetElectionList {
	
	public List<ConfigurationElection> getElections();

}
