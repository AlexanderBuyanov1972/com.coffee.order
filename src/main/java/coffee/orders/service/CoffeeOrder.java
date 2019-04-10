package coffee.orders.service;

import coffee.orders.dao.OurRepository;
import coffee.orders.dto.OrderDTO;
import coffee.orders.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CoffeeOrder implements ICoffeeOrder {
    @Autowired
    OurRepository repository;

    @Override
    public boolean createOrder(OrderDTO orderDTO) {
        Order order = repository.findById(orderDTO.emailAddress).orElse(null);
        if (order != null) {
            return false;
        } else {
            repository.save(getFormatOrderDTO(orderDTO));
            return true;
        }

    }

    private Order getFormatOrderDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.coffee = orderDTO.coffee;
        order.emailAddress = orderDTO.emailAddress;
        order.size = orderDTO.size;
        order.flavor = orderDTO.flavor;
        order.strength = orderDTO.strength;
        return order;
    }

    private OrderDTO getFormatOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.coffee = order.coffee;
        orderDTO.emailAddress = order.emailAddress;
        orderDTO.size = order.size;
        orderDTO.flavor = order.flavor;
        orderDTO.strength = order.strength;
        return orderDTO;
    }

    @Override
    public OrderDTO getOrder(String email) {
        Order order = repository.findById(email).orElse(null);
        if (order != null) {
            return getFormatOrder(order);
        } else {
            return new OrderDTO();
        }

    }

    @Override
    public boolean deliverOrder(String email) {
        Order order = repository.findById(email).orElse(null);
        if (order == null) {
            return false;
        } else {
            repository.delete(order);
            return true;
        }

    }

    @Override
    public boolean updateOrder(OrderDTO orderDTO) {
        Order order = repository.findById(orderDTO.emailAddress).orElse(null);
        if (order == null) {
            return false;
        } else {
            repository.delete(order);
            repository.save(getFormatOrderDTO(orderDTO));
            return true;
        }
    }

    @Override
    public List<Order> getAll() {
        Iterable<Order> list = repository.findAll();
        if (list == null) {
            return new LinkedList<Order>();
        } else {
            return (List<Order>) repository.findAll();
        }
    }

    @Override
    public boolean deliverAll() {
        repository.deleteAll();
        return true;
    }
}
