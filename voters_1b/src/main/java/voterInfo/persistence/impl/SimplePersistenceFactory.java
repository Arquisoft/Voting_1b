package voterInfo.persistence.impl;

import voterInfo.persistence.PersistenceFactory;
import voterInfo.persistence.UserDao;

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UserDao createUserDao() {
		return new UserJdbcDAO();
	}

	
}
