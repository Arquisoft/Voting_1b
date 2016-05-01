package dBManagement.impl;

import dBManagement.PersistenceFactory;
import dBManagement.GetVoter;

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public GetVoter createUserDao() {
		return new GetVoterInfo();
	}

	
}
