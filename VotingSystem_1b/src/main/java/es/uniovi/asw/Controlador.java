package es.uniovi.asw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class Controlador{
	
	
	@RequestMapping(method = RequestMethod.GET)
	public RedirectView localRedirect() {
	    RedirectView redirectView = new RedirectView();
	    
		redirectView.setUrl("index.xhtml");

	    return redirectView;
	}
    
}
