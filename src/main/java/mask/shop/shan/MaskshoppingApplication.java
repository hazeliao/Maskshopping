package mask.shop.shan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mask.shop.shan.domain.Category;
import mask.shop.shan.domain.CategoryRepository;
import mask.shop.shan.domain.Mask;
import mask.shop.shan.domain.MaskRepository;
import mask.shop.shan.domain.User;
import mask.shop.shan.domain.UserRepository;

@SpringBootApplication
public class MaskshoppingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MaskshoppingApplication.class);
	
	@Autowired
	private MaskRepository mrepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(MaskshoppingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(){
		return(args) -> {
			log.info("save a couple of masks");
			crepository.save(new Category("Exclusive"));
			crepository.save(new Category("Moisturizing"));
			crepository.save(new Category("Revitalizing"));
			
			mrepository.save(new Mask("Lancome", "Absolute L'extrait ultimate Rose Serum Mask",  300.00, crepository.findByName("Exclusive").get(0)));
			mrepository.save(new Mask("Guerlan", "Orchidee Imperiale Mask", 242.00, crepository.findByName("Revitalizing").get(0)));
			mrepository.save(new Mask("La Mer", "Hydrating Facial", 195.00, crepository.findByName("Moisturizing").get(0)));
			mrepository.save(new Mask("Sisley", "Express Flower Gel", 80.00, crepository.findByName("Moisturizing").get(0)));
			
			// Create users: admin/admin user/user
					User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
					User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
					User user3 = new User("user3", "user@gmail.com", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER1");
					urepository.save(user1);
						urepository.save(user2);
						urepository.save(user3);
					
			log.info("fetch all masks");
			for (Mask mask: mrepository.findAll()) {
				log.info(mask.toString());
		};
	
		};
	}
}
