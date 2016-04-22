package es.uniovi.asw.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;

public class TelematicVoterTest {
	
	@Test
	public void testTelematicVoter() {
		User user = new User("Nombre", "Mail", "Nif", null);
		TelematicVoter tv = new TelematicVoter(user, false, null);
		
		assertEquals(user, tv.getUser());
		assertEquals(null, tv.getConfigurationElection());
		assertEquals(false, tv.isVoted());
		tv.setVoted(true);
		assertEquals(true, tv.isVoted());
	}

}
