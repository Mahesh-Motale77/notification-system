## Local Development Setup

### Prerequisites
- Java 21
- MySQL 8 (installed locally, port 3306)
- Kafka 3.7 (installed at C:\kafka)
- Redis 3.x (installed as Windows service)

### Start Kafka
1. Start Zookeeper: bin\windows\zookeeper-server-start.bat config\zookeeper.properties
2. Start Kafka: bin\windows\kafka-server-start.bat config\server.properties

### Start Redis
Runs automatically as Windows service.

### Start Services
- order-service: port 8081
- notification-service: port 8082
- notification-management-api: port 8083