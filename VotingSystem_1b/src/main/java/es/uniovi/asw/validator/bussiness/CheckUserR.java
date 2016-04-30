package es.uniovi.asw.validator.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.CheckUser;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;

@Component
public class CheckUserR {
	
	@Autowired
	private CheckUser cu;
	
	public void validar(String email, String password) throws InvalidUserException{
		User u = cu.validar(email, password);
		
		if(u == null){
			throw new InvalidUserException("Datos de incio de sesion incorrectos");
		}
		
		if(!u.isAdmin()){
			throw new InvalidUserException("El usuario no tiene permisos");
		}
	}

}
