package recountAccess.persistence;

public interface PersistenceFactory {
	
	UserDao createUserDao();
	VoteDao createVoteDao();

}

