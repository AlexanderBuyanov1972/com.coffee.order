package coffee.orders.dao;

import coffee.orders.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OurRepository extends PagingAndSortingRepository<Order, String> {
}
