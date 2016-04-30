package es.uniovi.asw.voterVote;

import java.util.List;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

public interface getVotationOptions {

	

	List<VotableOption> getList(ConfigurationElection configurationElection);
}
