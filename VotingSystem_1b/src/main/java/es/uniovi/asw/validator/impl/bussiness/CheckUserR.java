package es.uniovi.asw.validator.impl.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.voteApplication.impl.exception.InvalidUserException;

@Component
public class CheckUserR {
	
	@Autowired
	private UserDAO ud;
	
	public void validar(String email, String password) throws InvalidUserException{
		User u = ud.findByMailAndContrasena(email, password);
		
		if(u == null){
			throw new InvalidUserException("Datos de incio de sesion incorrectos");
		}
		
		if(!u.isAdmin()){
			throw new InvalidUserException("El usuario no tiene permisos");
		}
	}

}
