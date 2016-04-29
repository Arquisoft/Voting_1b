package com.sdi.persistence.impl;


import main.java.persistence.UserDao;
import main.java.persistence.PersistenceFactory;

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UserDao createUserDao() {
		return new UserJdbcDAO();
	}

}
