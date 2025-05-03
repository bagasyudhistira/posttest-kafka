package id.co.ogya.posttest.kafka.dao;

import id.co.ogya.posttest.kafka.model.OrderEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {

    List<OrderEntity> getAllOrders();

    OrderEntity getOrderById(String orderId);

    void saveOrder(OrderEntity orderEntity);

    void updateOrder(OrderEntity orderEntity);

    void deleteOrder(String orderId);
}
