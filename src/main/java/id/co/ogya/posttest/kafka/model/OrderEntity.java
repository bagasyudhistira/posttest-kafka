package id.co.ogya.posttest.kafka.model;

import lombok.Data;

@Data
public class OrderEntity {
    private String orderId;
    private String productName;
    private Integer orderQuantity;
}
