package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
//MongoRepo <@Entity, @Id>. Comes with CRUD
	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	
}
