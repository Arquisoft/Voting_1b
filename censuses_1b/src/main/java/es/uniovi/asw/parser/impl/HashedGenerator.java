package es.uniovi.asw.parser.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

import es.uniovi.asw.DBUpdate.Votante;


public class HashedGenerator implements GeneradorContrasenas {

	@Override
	public String generar(Votante v) {
		SecureRandom passCreator = new SecureRandom();
		return new BigInteger(20, passCreator).toString()+v.hashCode();
		
		
	}

}
