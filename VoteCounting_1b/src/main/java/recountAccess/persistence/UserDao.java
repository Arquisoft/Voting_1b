package recountAccess.persistence;


import java.util.List;

import recountAccess.persistence.exception.*;

import recountAccess.model.User;

/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * 
 * En esta versi��n aparecen los otros m��todos b��sicos de un servicio 
 * de persistencia
 * 
 * @author alb
 *
 */
public interface UserDao {

	List<User> getUsers();
	void save(User a) throws AlreadyPersistedException;
	void update(User a) throws NotPersistedException;
	void delete(Long id) throws NotPersistedException;
	User findById(Long id);
	User findByLogin(String login);

}