package es.uniovi.asw.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.ElectoralCollege;

public class ElectoralCollegeTest {

	@Test
	public void testColegioBasico() {
		ElectoralCollege c = new ElectoralCollege("123", null);
		assertEquals("123",c.getCodigoColegio());
	}

}
