package es.uniovi.asw.configuration.business;

import java.util.List;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.VotableOption;

public interface VotableOptionService {

	void saveVotableOption(List<VotableOption> vo) throws PersistenceException;
}
