package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Raw on 6/20/2017.
 */

public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
            this.orderService=orderService;

    }

    @GetMapping("/order-list")
    public String orderList(Model model){
        List<Order> orders = orderService.getAll();
        System.out.println("list:"+orders);
        model.addAttribute("orders", orders);
        return "order-list";
    }

}
