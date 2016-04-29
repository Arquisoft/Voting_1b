package com.sdi.persistence;

import main.java.persistence.*;

public interface PersistenceFactory {
	
	UserDao createUserDao();
	VoteDao createVoteDao();

}

