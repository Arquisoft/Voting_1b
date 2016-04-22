package es.uniovi.asw.modelo;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.VotableOption;

public class ConfigurationElectionTest {
		
	@Test
	public void testBasicoConfiguration() {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date iniApp = null;
		Date finApp = null;
		Date iniVot = null;
		Date finVot = null;
		try {
			iniApp = df.parse("01/05/2016");
			finApp = df.parse("31/05/2016");
			iniVot = df.parse("01/06/2016");
			finVot = df.parse("04/06/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ElectoralCollege> electoralColleges = new ArrayList<ElectoralCollege>();
		electoralColleges.add(new ElectoralCollege("xyz", null));
		electoralColleges.add(new ElectoralCollege("abc", null));
		
		List<VotableOption> votableOptions = new ArrayList<VotableOption>();
		votableOptions.add(new VotableOption("Nombre", "La descripción de la opción.", null));
		votableOptions.add(new VotableOption("Nombre2", "Otra opción.", null));
		
		ConfigurationElection conf = new ConfigurationElection("Nombre", "La descripción.",
				iniApp, finApp, iniVot, finVot, votableOptions, electoralColleges, false);
		assertEquals("Nombre", conf.getName());		
		assertEquals("La descripción.", conf.getDescription());
		assertEquals(iniApp, conf.getApplicationStart());
		assertEquals(finApp, conf.getApplicationEnd());
		assertEquals(iniVot, conf.getVotationStart());
		assertEquals(finVot, conf.getVotationEnd());
		assertEquals(electoralColleges, conf.getElectoralColleges());
		assertEquals(votableOptions, conf.getVotableOptions());
		assertFalse(conf.isMultipleVoting());
		
	}

}
