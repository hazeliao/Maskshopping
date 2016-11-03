package mask.shop.shan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderList, Long> {
	List <OrderList> findByMask (Mask mask);
}
