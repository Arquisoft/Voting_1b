package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.DBUpdate.Votante;

public interface ReadCensus {

	public List<Votante> loadCenso() throws Exception;
	
}
