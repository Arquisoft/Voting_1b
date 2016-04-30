package es.uniovi.asw.dbupdate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.InsertVote;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
@Component
public class InsertVoteP implements InsertVote {

	@Autowired
	VotableOptionDAO vd;
	
	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;
	@Autowired(required=true)
	private VoteDAO votoDao;
	@Override
	public List<VotableOption> findByConfigurationElection(
			ConfigurationElection configurationElection) {
		return vd.findByConfigurationElection(configurationElection);
	}
	@Override
	public User findByMailAndContrasena(String email, String password) {
	return ud.findByMailAndContrasena(email, password);
	}
	@Override
	public void save(TelematicVoter miVotoTelematico) {
		td.save(miVotoTelematico);
		
	}
	@Override
	public TelematicVoter findByUserAndConfigurationElection(User user,
			ConfigurationElection c) {
		return td.findByUserAndConfigurationElection(user, c);
	}
	@Override
	public void save(Vote v) {
		votoDao.save(v);
		
	}
	
	
	
}
