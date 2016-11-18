package mask.shop.shan;

import static org.junit.Assert.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import mask.shop.shan.domain.CategoryRepository;
import mask.shop.shan.domain.Mask;
import mask.shop.shan.domain.OrderRepository;
import mask.shop.shan.domain.MaskRepository;
import mask.shop.shan.domain.User;
import mask.shop.shan.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class RepositoryTest {
	@Autowired
	private MaskRepository mrepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private OrderRepository orepository;
	
	//testing to find mask by mask name
	@Test
	public void findByNameShouldReturnMask(){
		List<Mask> masks = mrepository.findByName("Lancome");
		assertThat(masks).hasSize(1);
		assertThat(masks.get(0).getDescription()).isEqualTo("Absolute L'extrait ultimate Rose Serum Mask");
	}
	
	// testing add new mask and delete mask
	@Test
	public void createAndDeleteNewMask(){
		Mask mask = new Mask("SK II", "Facial Treatment Mask", 85.99, crepository.findByName("Revitalizing").get(0));
		mrepository.save(mask);
		assertThat(mask.getId()).isNotNull();
		mrepository.delete(mask.getId());
		assertFalse(mrepository.exists(mask.getId()));
		}
	
	//testing find user role
	@Test
	public void findByRoleShouldReturnUser(){		
		List<User> users=urepository.findByRole("USER");		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("user");		
	}
	
	//testing add new user and delete user
	@Test
	public void createAndDeleteNewUser(){
		User user= new User("user4", "gooe@email.com", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER2" );
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
		urepository.delete(user);
		assertFalse(urepository.exists(user.getId()));
	}
		
	
}
