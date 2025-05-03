package id.co.ogya.posttest.kafka.consumer;

import id.co.ogya.posttest.kafka.service.OrderService;
import id.co.ogya.posttest.kafka.model.OrderEntity;
import id.co.ogya.posttest.kafka.model.OrderEvent;
import id.co.ogya.posttest.kafka.model.OperationType;
import id.co.ogya.posttest.kafka.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consumeOrderEvent(OrderEvent orderEvent) {
        System.out.println("🛎 Received Order Event: " + orderEvent);

        OrderEntity entity = new OrderEntity();
        entity.setOrderId(orderEvent.getData().getOrderId().toString());
        entity.setProductName(orderEvent.getData().getProductName() != null ? orderEvent.getData().getProductName().toString() : null);
        entity.setOrderQuantity(orderEvent.getData().getOrderQuantity());

        if (orderEvent.getOperation() == OperationType.CREATE) {
            orderService.saveOrder(entity);
        } else if (orderEvent.getOperation() == OperationType.UPDATE) {
            orderService.updateOrder(entity);
        } else if (orderEvent.getOperation() == OperationType.DELETE) {
            orderService.deleteOrder(entity.getOrderId());
        }
    }
}
