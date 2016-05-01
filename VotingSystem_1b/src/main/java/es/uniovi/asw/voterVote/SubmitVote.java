package es.uniovi.asw.voterVote;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

public interface SubmitVote {

	public void vote(ConfigurationElection configurationElection, VotableOption selectOption, String email, String password);
}
