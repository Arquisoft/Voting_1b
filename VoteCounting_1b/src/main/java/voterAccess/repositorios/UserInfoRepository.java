package voterAccess.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import voterAccess.model.User;



public interface UserInfoRepository extends CrudRepository<User, Long>{
	
	List<User> findByLogin(String email);
	List<User> findAll();
	
	
}
