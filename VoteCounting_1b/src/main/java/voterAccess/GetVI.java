package voterAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import voterAccess.model.UserInfo;

public class GetVI implements GetVoterInfo{

	@Autowired
    DBManager repos;
	
	
	
	public GetVI(DBManager repository) {
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
