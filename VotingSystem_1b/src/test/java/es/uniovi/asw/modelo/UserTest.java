package es.uniovi.asw.modelo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;

public class UserTest {

	@Test
	public void testBasicoUsuario() {
		User u = new User("nombre", "mail", "nif", null);
		u.setContrasena("123");
		assertEquals("123", u.getContrasena());
		assertEquals("nombre",u.getNombre());
		assertEquals("mail",u.getMail());
		assertEquals("nif",u.getNif());
		assertEquals(null, u.getCodigoColegio());
		
		TelematicVoter t= new TelematicVoter(u, false, null);
		List<TelematicVoter> lista= new ArrayList<TelematicVoter>();
		lista.add(t);
		u.setTelematicVote(lista);
		assertEquals(lista, u.getTelematicVote());	
	}

}
