package dBManagement;


import java.util.List;

import dBManagement.exception.AlreadyPersistedException;
import dBManagement.exception.NotPersistedException;
import voterAccess.model.User;



/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * 
 * En esta versi��n aparecen los otros m��todos b��sicos de un servicio 
 * de persistencia
 * 
 * @author alb
 *
 */
public interface GetVoter {

	List<User> getUsers();
	void save(User a) throws AlreadyPersistedException;
	void update(User a) throws NotPersistedException;
	void delete(Long id) throws NotPersistedException;
	User findById(Long id);
	User findByLogin(String login);

}