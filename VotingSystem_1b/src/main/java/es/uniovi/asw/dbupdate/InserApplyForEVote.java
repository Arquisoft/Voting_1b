package es.uniovi.asw.dbupdate;

import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;

@Component
public interface InserApplyForEVote {
	
	public User geUserInfo(String email, String password);
	public boolean alreadyTelematicVoter(User user, ConfigurationElection configurationElection);
	public void insertTelematicVoter(TelematicVoter telematicVoter);

}