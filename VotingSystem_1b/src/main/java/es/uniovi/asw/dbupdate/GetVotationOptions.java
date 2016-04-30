package es.uniovi.asw.dbupdate;

import java.util.List;

import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
@Component
public interface GetVotationOptions {

	List<VotableOption> findByConfigurationElection(
			ConfigurationElection configurationElection);
	
}
