package hello;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DBManager extends CrudRepository<UserInfo, Long>{
	
	List<UserInfo> findByLogin(String email);
	List<UserInfo> findAll();
	
	
}
