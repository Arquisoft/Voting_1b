package es.uniovi.asw;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
@EnableJpaRepositories
@RequestMapping("/")
public class Main extends SpringBootServletInitializer implements ServletContextAware {
	//bug magicp
    public static void main(String[] args) {
        SpringApplication.run(Main.class);   
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);     
        return registration;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");   
        servletContext.addListener(com.sun.faces.config.ConfigureListener.class);
    }

    
    @RequestMapping(method = RequestMethod.GET)
	public RedirectView localRedirect() {
	    RedirectView redirectView = new RedirectView();
	    
		redirectView.setUrl("index.xhtml");

	    return redirectView;
	}

    
    	
    	
        
    
}
