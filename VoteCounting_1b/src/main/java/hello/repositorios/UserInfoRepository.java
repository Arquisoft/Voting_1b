package hello.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import hello.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	
	List<UserInfo> findByLogin(String email);
	List<UserInfo> findAll();
	
	
}
