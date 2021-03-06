package coffee.orders.controller;

import coffee.orders.dto.OrderDTO;
import coffee.orders.entity.Order;
import coffee.orders.service.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCoffeeOrder {
    @Autowired
    CoffeeOrder coffeeOrder;

    @PostMapping(value = "/create")
    boolean createOrder(@RequestBody OrderDTO orderDTO) {
        return coffeeOrder.createOrder(orderDTO);
    }

    @GetMapping(value = "/get")
    OrderDTO getOrder(@RequestParam(value = "emailAddress") String emailAddress) {
        return coffeeOrder.getOrder(emailAddress);
    }

    @DeleteMapping(value = "/delete")
    boolean deliverOrder(@RequestParam(value = "emailAddress") String emailAddress) {
        return coffeeOrder.deliverOrder(emailAddress);
    }

    @PutMapping(value = "/update")
    boolean updateOrder(@RequestBody OrderDTO orderDTO) {
        return coffeeOrder.updateOrder(orderDTO);
    }

    @GetMapping(value = "/getAll")
    List<Order> getAll() {
        return coffeeOrder.getAll();
    }

    @DeleteMapping(value = "/deleteAll")
    boolean deliverAll() {
        return coffeeOrder.deliverAll();
    }


}
