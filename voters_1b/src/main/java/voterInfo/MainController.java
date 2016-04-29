package voterInfo;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import voterInfo.model.User;
import voterInfo.persistence.UserDao;
import voterInfo.persistence.exception.NotPersistedException;
import voterInfo.persistence.impl.SimplePersistenceFactory;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Controller
public class MainController {

	User user;
	//@Autowired
	//UserInfoRepository repository;
	
	UserDao repository = new SimplePersistenceFactory().createUserDao();
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    	//user=new User("bla","000", "bla", "24252627W", 2535);
        model.addAttribute("userinfo", new User());
        return "greeting";
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute User greeting, Model model, HttpSession sesion) {
    	
    	try{
    		User users=repository.findByLogin(greeting.getLogin());
        	if (users!=null){
        		model.addAttribute("userinfo", users);
        		User usuario=users;
        		if(usuario.getPassword().equals(greeting.getPassword())){
        			sesion.setAttribute("login", greeting.getLogin());
        			return "result";
        		}else{
        	        throw new HTTP404Exception();  
        		}
        	}
        	}catch(IndexOutOfBoundsException e){
                throw new HTTP404Exception();  
        	}
        return "result";
    }
    
    @RequestMapping(value="/cambiar-clave", method=RequestMethod.GET)
    public String cambiarClave(Model model) {
    	model.addAttribute("cambiarClave", new CambiarClave());
    	return "cambiar-clave";
    }
    
    @RequestMapping(value="/cambiar-clave", method=RequestMethod.POST)
    public String cambiarClaveSubmit(@Valid @ModelAttribute CambiarClave cambiarClave, BindingResult br, HttpSession sesion) {
    	if (br.hasErrors()) {
    		return "cambiar-clave";
    	}
    	else {
    		String login = (String)sesion.getAttribute("login");
    		User users = repository.findByLogin(login);
    		if (users == null) {
    			throw new RuntimeException();
    		}
    		else {
    			User userInfo = users;
				if (userInfo.getPassword().equals(cambiarClave.getClaveAnterior())) {
					userInfo.changePassword(cambiarClave.getClaveNueva());
					try {
						repository.update(userInfo);
					} catch (NotPersistedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
    			else {
    	    		br.addError(new FieldError("cambiarClave", "claveAnterior", "Clave anterior mal"));
    			}
    		}
	    	return "redirect:/";
    	}
    }
}