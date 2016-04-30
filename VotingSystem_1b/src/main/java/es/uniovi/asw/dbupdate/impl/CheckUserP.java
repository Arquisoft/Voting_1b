package es.uniovi.asw.dbupdate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.CheckUser;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.UserDAO;

@Component
public class CheckUserP implements CheckUser {
	
	@Autowired(required=true)
	private UserDAO ud;
	
	public User validar(String email, String password){
		return ud.findByMailAndContrasena(email, password);
	}

}
