package hello;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import voterInfo.Application;
import voterInfo.DBManager;
import voterInfo.model.UserInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class MainControllerTest {

	private static final Logger log = LoggerFactory.getLogger(DBManager.class);
	
    @Value("${local.server.port}")
    private int port;

    @Autowired
    DBManager repository;
    
    private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}
	
	@Test
	public void getUser() throws Exception {
		String userURI = base.toString() + "/user";  
		@SuppressWarnings("unused")
		ResponseEntity<String> response = template.getForEntity(userURI, String.class);
		@SuppressWarnings("unused")
		UserInfo expected = new UserInfo("pepe@gmail.com","0000", "pepe", "50505050Y", 2535);
	}
	
	@Test
	public void getUsers() throws Exception{
		// fetch all customers
					log.info("\n");
					log.info("Customers found with findAll():");
					log.info("-------------------------------");
					for (UserInfo customer : repository.findAll()) {
						log.info(customer.toString());
					}
		
		//UserInfo expected = new UserInfo("juan@gmail.com","000", "Juan", "24252627X", 2535);
		//UserInfo recived = repository.findByLogin("juan@gmail.com").get(0);
		//if( !expected.equals(recived))
			//throw new Exception();
	}

}