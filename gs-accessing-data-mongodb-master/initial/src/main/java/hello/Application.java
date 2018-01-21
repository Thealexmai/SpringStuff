package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired //injection
	private CustomerRepository customerRepo;
	
	@Override
	public void run(String... args) throws Exception { 
		//can be invoked by an array String[] args or strings separated by commas, or no args
		customerRepo.deleteAll();
		
		customerRepo.save(new Customer("Alex", "Mai"));
		customerRepo.save(new Customer("Phil", "Mai"));
		customerRepo.save(new Customer("Lukas", "Zheng"));
		
		//findAll()
		for (Customer temp: customerRepo.findAll()) {
			System.out.println(temp);
		}
		System.out.println();
		
		//find specific customers
		System.out.println("Finding customers with last name 'Mai': ");
		for (Customer temp: customerRepo.findByLastName("Mai")) {
			System.out.println(temp);
		}
		System.out.println();
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}
