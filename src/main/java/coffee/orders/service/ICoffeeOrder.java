package coffee.orders.service;

import coffee.orders.dto.OrderDTO;
import coffee.orders.entity.Order;

import java.util.List;

public interface ICoffeeOrder {

    boolean createOrder(OrderDTO orderDTO);

    OrderDTO getOrder(String email);

    boolean deliverOrder(String email);

    boolean updateOrder(OrderDTO orderDTO);

    List<Order> getAll();

    boolean deliverAll();


}
