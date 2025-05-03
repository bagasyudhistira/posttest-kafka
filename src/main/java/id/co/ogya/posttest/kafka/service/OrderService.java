package id.co.ogya.posttest.kafka.service;

import id.co.ogya.posttest.kafka.model.OrderEntity;
import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOrders();

    OrderEntity getOrderById(String orderId);

    void saveOrder(OrderEntity orderEntity);

    void updateOrder(OrderEntity orderEntity);

    void deleteOrder(String orderId);
}

