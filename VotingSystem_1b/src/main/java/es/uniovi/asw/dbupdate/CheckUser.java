package es.uniovi.asw.dbupdate;

import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.User;

@Component
public interface CheckUser {
	
	public User validar(String email, String password);

}
