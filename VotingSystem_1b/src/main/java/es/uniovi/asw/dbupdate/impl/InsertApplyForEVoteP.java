package es.uniovi.asw.dbupdate.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.dbupdate.InserApplyForEVote;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;

public class InsertApplyForEVoteP implements InserApplyForEVote {
	
	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;

	@Override
	public User geUserInfo(String mail, String password) {
		return ud.findByMailAndContrasena(mail, password);
	}

	@Override
	public void insertTelematicVoter(TelematicVoter telematicVoter) {
		td.save(telematicVoter);
	}

	@Override
	public boolean alreadyTelematicVoter(User user,
			ConfigurationElection configurationElection) {
		return td.findByUserAndConfigurationElection(user, configurationElection) != null;
	}

}
