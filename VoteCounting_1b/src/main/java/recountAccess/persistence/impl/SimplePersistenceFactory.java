package recountAccess.persistence.impl;


import recountAccess.persistence.UserDao;
import recountAccess.persistence.VoteDao;
import recountAccess.persistence.PersistenceFactory;

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UserDao createUserDao() {
		return new UserJdbcDAO();
	}

	@Override
	public VoteDao createVoteDao() {
		return new VoteJdbcDAO();
	}

}
