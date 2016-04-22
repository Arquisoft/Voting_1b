package hello;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Controller
public class MainController {
	
	UserInfo user;
	@Autowired
    DBManager repository;	
	GetVoterInfo infoPort;
	 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("userinfo", new UserInfo());
        return "greeting";
    }
       
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UserInfo greeting, Model model, HttpSession sesion) {
  
    	model.addAttribute("userinfo", greeting);
    	infoPort= new VoterAccess(repository);
    	try{
    				UserInfo usuario=infoPort.getInfo(greeting.getLogin(),greeting.getPassword() );
        			sesion.setAttribute("login", greeting.getLogin());
        			model.addAttribute("userinfo", usuario);
        			return "result";
        	}catch(IndexOutOfBoundsException e){
                throw new HTTP404Exception();  
        	}
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
    		
    		List<UserInfo> users = repository.findByLogin(login);
    		
    		if (users.isEmpty()) {
    			throw new RuntimeException();
    		}
    		else {
    			UserInfo userInfo = users.get(0);
    			if (userInfo.getPassword().equals(cambiarClave.getClaveAnterior())) {
        			userInfo.changePassword(cambiarClave.getClaveNueva());
        			repository.save(userInfo);
    			}
    			else {
    	    		br.addError(new FieldError("cambiarClave", "claveAnterior", "Clave anterior mal"));
    			}
    		}    		
	    	return "redirect:/";
    	}
    }

}