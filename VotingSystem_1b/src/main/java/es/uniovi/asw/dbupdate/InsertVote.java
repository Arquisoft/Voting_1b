package es.uniovi.asw.dbupdate;

import java.util.List;

import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

@Component
public interface InsertVote {

	List<VotableOption> findByConfigurationElection(
			ConfigurationElection configurationElection);

	User findByMailAndContrasena(String email, String password);

	void save(TelematicVoter miVotoTelematico);

	TelematicVoter findByUserAndConfigurationElection(User user,
			ConfigurationElection c);

	void save(Vote v);
	
	public void loadVoteForOption(ConfigurationElection c, Vote v, String email, String password) throws BusinessException, InvalidUserException;

}