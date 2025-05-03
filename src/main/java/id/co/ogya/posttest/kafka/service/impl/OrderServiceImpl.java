package id.co.ogya.posttest.kafka.service.impl;

import id.co.ogya.posttest.kafka.dao.OrderDao;
import id.co.ogya.posttest.kafka.model.OrderEntity;
import id.co.ogya.posttest.kafka.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public OrderEntity getOrderById(String orderId) {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public void saveOrder(OrderEntity orderEntity) {
        System.out.println("===> DAO class: " + orderDao.getClass());
        orderDao.saveOrder(orderEntity);
    }

    @Override
    public void updateOrder(OrderEntity orderEntity) {
        orderDao.updateOrder(orderEntity);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderDao.deleteOrder(orderId);
    }
}
