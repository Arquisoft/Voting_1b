package es.uniovi.asw.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.VotableOption;

public class VotableOptionTest {
	
	@Test
	public void testBasicoVotableOption() {
		VotableOption vo = new VotableOption("Nombre", "Descripción.", null);
		
		assertEquals("Nombre", vo.getNombre());
		assertEquals("Descripción.", vo.getDescripcion());
		assertNull(null, vo.getConfigurationElection());
	}

}
