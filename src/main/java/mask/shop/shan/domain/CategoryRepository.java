package mask.shop.shan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mask.shop.shan.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category>findByName(String name);
}
