package voterAccess;

import voterAccess.model.UserInfo;

public interface GetVoterInfo {

	public UserInfo getInfo(String email,String pass);
	
	
}
