package es.uniovi.asw.voteInput;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;
import es.uniovi.asw.voterVote.impl.exception.BusinessException;

public interface SelectVote {

	public void loadVote();
	
}
