package voterInfo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import voterInfo.model.UserInfo;

public interface DBManager extends CrudRepository<UserInfo, Long>{
	
	List<UserInfo> findByLogin(String email);
	List<UserInfo> findAll();
	
	
}
