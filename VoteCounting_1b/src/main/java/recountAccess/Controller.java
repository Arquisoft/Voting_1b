package recountAccess;

import java.util.List;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import recountAccess.model.User;
import recountAccess.repositorios.UserInfoRepository;
import recountAccess.persistence.*;

//controlador para la parte por Consola

@RestController
public class Controller {
	
	
	//@Autowired
    //UserInfoRepository repository;
	UserJdbcDAO repository= new SimplePersistenceFactory.createUserDao();
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User update(@RequestBody User car) {	
    	Integer pollingStationCode;
        if (car != null) {
        	try{
        	List<User> users=repository.findByLogin(car.getLogin());
        	if (users!=null){
        		User usuario=users.get(0);
        		if(usuario.getPassword().equals(car.getPassword())){
        			pollingStationCode=usuario.getPollingStationCode();
        			car=usuario;
        			System.out.print(pollingStationCode);
        			return car;	
        		}else{
        	        throw new HTTP404Exception();  
        		}
        	}
        	}catch(IndexOutOfBoundsException e){
                throw new HTTP404Exception();  
        	}
        }
        throw new HTTP404Exception();  
    }	
}
