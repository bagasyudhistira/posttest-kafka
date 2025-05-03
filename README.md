# Kafka Order Processor

Proyek ini adalah layanan Spring Boot untuk memproses event `Order` melalui Kafka dan menyimpannya ke PostgreSQL menggunakan MyBatis.

## 🔧 Instalasi

1. **Clone repository**
   ```bash
   git clone git remote add origin https://github.com/bagasyudhistira/posttest-kafka.git
   cd posttest.kafka
   ```

2. **Jalankan Kafka, Schema Registry, dan PostgreSQL dengan Docker Compose**
    ```bash
    docker compose up -d
    ```

3. **Setup database PostgreSQL**
    ```sql
    CREATE DATABASE kafka_training;

    CREATE SCHEMA posttest;

    CREATE TABLE posttest.orders (
    order_id VARCHAR PRIMARY KEY,
    product_name VARCHAR,
    order_quantity INT NOT NULL
    );
    ```

4. **Generate Avro Class**
    ```bash
    mvn clean generate-sources
    ```

5. **Jalankan aplikasi**
    ```bash
    mvn spring-boot:run
    ```

## 🚀 Cara Menggunakan

1. Kirim event ke Kafka (contoh pakai Kafka Avro Console Producer)
    Simpan schema Avro di file order-event.avsc, lalu jalankan:
    ```bash
    docker exec -it posttestkafka-kafka bash

    kafka-avro-console-producer \
    --broker-list localhost:9092 \
    --topic order-topic \
    --property schema.registry.url=http://localhost:8081 \
    --property value.schema="$(< src/main/avro/order-event.avsc)"
    ```
2. Contoh JSON yang Dikirim
    - CREATE:
    ```json
    {
        "operation": "CREATE",
        "data": {
            "orderId": "ORD001",
            "productName": "AirPods Pro",
            "orderQuantity": 2
        }
    }
    ```
    - UPDATE:

    *Jika terdapat field yang tidak ingin diubah, cukup tidak menyertakan field tersebut dalam JSON yang dikirim atau diisi dengan nilai null.*
    ```json
    {
        "operation": "UPDATE",
        "data": {
            "orderId": "ORD001",
            "productName": "AirPods Pro 2",
            "orderQuantity": null
        }
    }
    ```
    - DELETE:
    ```json
    {
        "operation": "DELETE",
        "data": {
            "orderId": "ORD001",
            "productName": null,
            "orderQuantity": null
        }
    }
    ```
