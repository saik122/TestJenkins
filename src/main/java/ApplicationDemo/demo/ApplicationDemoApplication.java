package ApplicationDemo.demo;

import ApplicationDemo.demo.model.Alien;
import ApplicationDemo.demo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApplicationDemoApplication.class, args);

		Alien alien = new Alien();
//		alien.setId(101);
//		alien.setName("sai");
//		alien.setTech("java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien);


	}

}
