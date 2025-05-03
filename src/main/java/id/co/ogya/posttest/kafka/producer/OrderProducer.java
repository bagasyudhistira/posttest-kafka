package id.co.ogya.posttest.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import id.co.ogya.posttest.kafka.model.OrderEvent;

@Service
public class OrderProducer {
    private static final String TOPIC = "order-topic";

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void send(OrderEvent orderEvent) {
        kafkaTemplate.send(TOPIC, orderEvent);
    }
}
