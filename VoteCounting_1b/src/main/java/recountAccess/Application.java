package recountAccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import recountAccess.model.User;
import recountAccess.model.Vote;
import recountAccess.repositorios.UserInfoRepository;
import recountAccess.repositorios.VoteRepository;

@SpringBootApplication
public class Application {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UserInfoRepository.class);
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
  
	@Bean
	public CommandLineRunner loaduser(UserInfoRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("bla","000", "bla", "24252627W", new Long(2535)));
			repository.save(new User("pablo@gmail.com","000", "Pablo", "24252647W", new Long(2535)));
			repository.save(new User("juan@gmail.com","000", "Juan", "24252627X", new Long(2535)));
			repository.save(new User("maria@gmail.com","000", "María", "24252627Y", new Long(2500)));
			repository.save(new User("aida@gmail.com","000", "Aida", "24252627Z", new Long(2500)));
			
			
			
		};
    }
	
	@Bean
	public CommandLineRunner loadvotes(VoteRepository repository) {
		return (args) -> {
			repository.save(new Vote("PSOE", 2535));
			repository.save(new Vote("PP", 2500));
			repository.save(new Vote("PSOE", 2535));
			repository.save(new Vote("PSOE", 2500));
			repository.save(new Vote("PSOE", 2500));
			repository.save(new Vote("IU", 2151));
			repository.save(new Vote("Ciudadanos", 2151));
			repository.save(new Vote("PSOE", 2151));
			repository.save(new Vote("PSOE", 2151));
		};
	}
    
    
}