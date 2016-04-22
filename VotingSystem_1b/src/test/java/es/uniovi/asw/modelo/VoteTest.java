package es.uniovi.asw.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.Vote;

public class VoteTest {

	@Test
	public void testVoteBasico() {
		Date fecha = new Date();
		
		Vote v= new Vote(fecha, null, null, 1);
		assertEquals(v.getCantidad(), 1);
		assertEquals(fecha, v.getFecha());
		
	}

}
