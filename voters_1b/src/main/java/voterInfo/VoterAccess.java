package voterInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import voterInfo.model.UserInfo;

public class VoterAccess implements GetVoterInfo{

	@Autowired
    DBManager repos;
	
	
	
	public VoterAccess(DBManager repository) {
		repos=repository;
	}
	
	@Override
	public UserInfo getInfo(String email, String pass) {
		
		try{
		//busco el usuario por el login
		List<UserInfo> users=repos.findByLogin(email);
		
		UserInfo usuario=users.get(0);
		if(usuario.getPassword().equals(pass)){
			
			return usuario;
			
		}else{
			throw new HTTP404Exception(); 
		}
		}catch(IndexOutOfBoundsException e){
            throw new HTTP404Exception();  
    	}
		
	}

}
