package voterAccess;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dBManagement.GetVoter;
import dBManagement.impl.SimplePersistenceFactory;
import voterAccess.model.User;

//controlador para la parte por Consola

@RestController
public class Controller {
	
	
	//@Autowired
    //UserInfoRepository repository;
	GetVoter repository= new SimplePersistenceFactory().createUserDao();
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User update(@RequestBody User car) {	
    	Long pollingStationCode;
        if (car != null) {
        	try{
        	User users=repository.findByLogin(car.getLogin());
        	if (users!=null){
        		User usuario=users;
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
