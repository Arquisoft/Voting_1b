package es.uniovi.asw.voterVote.impl.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.GetElectionList;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

@Component
public class GetElectionListR {
	
	@Autowired
	private GetElectionList el;
	
	public List<ConfigurationElection> getElections(){
		return el.getElections();
	}

}
