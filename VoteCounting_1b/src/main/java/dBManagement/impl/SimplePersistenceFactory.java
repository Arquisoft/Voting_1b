package dBManagement.impl;

import dBManagement.PersistenceFactory;
import dBManagement.UserDao;
import dBManagement.GetVotes;

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UserDao createUserDao() {
		return new UserJdbcDAO();
	}

	@Override
	public GetVotes createVoteDao() {
		return new GetV();
	}

}
