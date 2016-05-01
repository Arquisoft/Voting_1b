package dBManagement;

public interface PersistenceFactory {
	
	UserDao createUserDao();
	GetVotes createVoteDao();

}

