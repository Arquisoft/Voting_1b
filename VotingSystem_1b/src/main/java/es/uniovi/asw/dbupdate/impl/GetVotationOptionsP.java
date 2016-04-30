package es.uniovi.asw.dbupdate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.GetVotationOptions;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;
@Component
public class GetVotationOptionsP implements GetVotationOptions {
	@Autowired
	VotableOptionDAO vd;
	@Override
	public List<VotableOption> findByConfigurationElection(
			ConfigurationElection configurationElection) {
		return vd.findByConfigurationElection(configurationElection);
	}

}
