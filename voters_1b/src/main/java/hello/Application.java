package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(DBManager.class);
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
  
	@Bean
	public CommandLineRunner demo(DBManager repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new UserInfo("bla","000", "bla", "24252627W", 2535));
			repository.save(new UserInfo("pablo@gmail.com","000", "Pablo", "24252647W", 2535));
			repository.save(new UserInfo("juan@gmail.com","000", "Juan", "24252627X", 2535));
			repository.save(new UserInfo("maria@gmail.com","000", "María", "24252627Y", 2500));
			repository.save(new UserInfo("aida@gmail.com","000", "Aida", "24252627Z", 2500));
					
		};
    }
    
    
}