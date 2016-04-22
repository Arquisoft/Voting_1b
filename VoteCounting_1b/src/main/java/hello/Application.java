package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.model.UserInfo;
import hello.model.Vote;
import hello.repositorios.UserInfoRepository;
import hello.repositorios.VoteRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(UserInfoRepository.class);
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
  
	@Bean
	public CommandLineRunner loaduser(UserInfoRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new UserInfo("bla","000", "bla", "24252627W", 2535));
			repository.save(new UserInfo("pablo@gmail.com","000", "Pablo", "24252647W", 2535));
			repository.save(new UserInfo("juan@gmail.com","000", "Juan", "24252627X", 2535));
			repository.save(new UserInfo("maria@gmail.com","000", "María", "24252627Y", 2500));
			repository.save(new UserInfo("aida@gmail.com","000", "Aida", "24252627Z", 2500));
			
			
			
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