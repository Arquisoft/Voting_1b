package voterInfo;

import voterInfo.model.UserInfo;

public interface GetVoterInfo {

	public UserInfo getInfo(String email,String pass);
	
	
}
