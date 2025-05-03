package id.co.ogya.posttest.kafka.controller;

import id.co.ogya.posttest.kafka.model.OrderEvent;
import id.co.ogya.posttest.kafka.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public String sendOrder(@RequestBody OrderEvent orderEvent) {
        orderProducer.send(orderEvent);
        return "Order sent to Kafka!";
    }
}

