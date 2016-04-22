package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.User;

@Repository
public interface UserDAO  extends CrudRepository<User, Long> { 

	   public User findByMailAndContrasena(String mail, String contrasena);
	   	
}
