package mask.shop.shan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mask.shop.shan.domain.Mask;

public interface MaskRepository  extends CrudRepository<Mask,Long>{
	Mask findById(Long id);
	List<Mask>findByName(String name);
}
