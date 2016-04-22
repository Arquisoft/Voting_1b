package hello;

import java.util.List;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controlador para la parte por Consola

@RestController
public class Controller {
	
	
	@Autowired
    DBManager repository;
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserInfo update(@RequestBody UserInfo car) {
    	
    	
    	Integer pollingStationCode;

        if (car != null) {
          //aqui mediante el objeto car busco en la base si existe
        	try{
        	List<UserInfo> users=repository.findByLogin(car.getLogin());
        	
        	if (users!=null){
        		UserInfo usuario=users.get(0);
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
