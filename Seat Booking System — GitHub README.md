# 🎟️ Seat Booking System

A **microservices-based movie seat booking system** built using **Java, Spring Boot, Spring Data JPA, MySQL, OpenFeign, and Apache Kafka**.

The project focuses on handling **seat availability, temporary seat holds, concurrent booking attempts, payment flow, and asynchronous booking notifications**.

A key design goal is to prevent **double booking** when multiple users attempt to reserve the same seat concurrently.

---

## 🏗️ Architecture

```text
                         ┌───────────────┐
                         │     Client    │
                         └───────┬───────┘
                                 │
                                 ▼
                    ┌──────────────────────┐
                    │  Catalog / Show      │
                    │      Service         │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │  Seat Inventory       │
                    │      Service          │
                    └──────────┬───────────┘
                               │
                          Hold Seat
                               │
                               ▼
                    ┌──────────────────────┐
                    │   Booking Service     │
                    └──────────┬───────────┘
                               │
                 ┌─────────────┴─────────────┐
                 ▼                           ▼
        ┌────────────────┐          ┌────────────────┐
        │ Payment Service│          │     Kafka      │
        └────────────────┘          │ booking-events│
                                    └───────┬────────┘
                                            │
                                            ▼
                                  ┌──────────────────┐
                                  │ Notification     │
                                  │    Service      │
                                  └──────────────────┘
```

---

## 🧩 Services

| Service | Responsibility |
|---|---|
| **User Service** | User-related operations |
| **Catalog / Show Service** | Movies, screens and shows |
| **Seat Inventory Service** | Seat availability and seat holds |
| **Booking Service** | Booking orchestration and lifecycle |
| **Payment Service** | Payment processing |
| **Notification Service** | Consumes booking events and handles notifications |

Each service is independently structured and communicates through REST APIs or asynchronous Kafka events where appropriate.

---

## 🔄 Booking Flow

```text
User
 │
 ▼
Select Movie
 │
 ▼
Select Show
 │
 ▼
Check Seat Availability
 │
 ▼
Hold Seat
 │
 ├── Failed ──► Seat unavailable
 │
 ▼
Payment
 │
 ├── Failed ──► Release Seat
 │
 ▼
Booking Confirmed
 │
 ▼
Publish Booking Event
 │
 ▼
Kafka
 │
 ▼
Notification Service
```

---

## 💺 Seat Management

Seats for a show are maintained using the `ShowSeat` entity.

A simplified seat lifecycle is:

```text
AVAILABLE
    │
    ▼
  HELD
   │ │
   │ └──────► Hold expires ──► AVAILABLE
   │
   ▼
 BOOKED
```

A seat is temporarily held while the user proceeds through the payment process.

This prevents another user from selecting the same seat during the payment window.

---

## 🔐 Preventing Double Booking

The project uses **JPA optimistic locking** through the `@Version` field on `ShowSeat`.

```java
@Version
private Integer version;
```

When two users attempt to modify the same seat concurrently, Hibernate detects the version conflict and prevents the stale transaction from overwriting the successful update.

Example:

```text
Initial Seat
Version = 1
    │
    ├──────────────┐
    ▼              ▼
 User A          User B
 Version 1       Version 1
    │              │
    ▼              │
 Update            │
 Version → 2       │
                   ▼
             Version conflict
                   │
                   ▼
             Update rejected
```

This ensures that only one concurrent request can successfully change the seat state.

---

## 🔗 Service-to-Service Communication

The Booking Service communicates with the Seat Inventory Service using **OpenFeign**.

Example:

```java
@FeignClient(
    name = "seat-inventory-service",
    url = "http://localhost:8082"
)
public interface SeatInventoryClient {

    @PostMapping("/inventory/hold")
    HoldSeatResponse holdSeat(
        @RequestBody HoldSeatRequest request
    );
}
```

Feign provides a declarative REST client and reduces the boilerplate required for inter-service communication.

---

## 📨 Kafka Event Processing

After a successful booking, the Booking Service publishes a booking event to Kafka.

```text
Booking Service
      │
      ▼
BookingEventProducer
      │
      ▼
 booking-events
      │
      ▼
Notification Service
```

The Notification Service consumes the event asynchronously.

This keeps notification processing decoupled from the core booking flow.

---

## 🔄 Transaction Management

The seat-holding operation is executed within a transaction:

```java
@Transactional
public HoldSeatResponse holdSeat(HoldSeatRequest request) {
    // Validate seat
    // Update seat state
    // Persist changes
}
```

This ensures that the seat state update is atomic and that database changes are rolled back if the transaction fails.

---

## 🛠️ Tech Stack

**Backend**

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs
- OpenFeign

**Messaging**

- Apache Kafka

**Database**

- MySQL

**Build**

- Maven

**Version Control**

- Git / GitHub

---

## 🚀 Running the Project

### Prerequisites

Make sure the following are installed:

- Java 17+
- Maven
- MySQL
- Apache Kafka
- Git

Verify:

```bash
java -version
mvn -version
git --version
```

### Database

Create the required MySQL databases and configure the connection in each service's `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seat_booking
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

Update the database credentials according to your local environment.

### Start the Services

Start Kafka and then run the required Spring Boot services.

The service ports can be configured through their respective `application.properties` files.

---

## 📡 Example API

### Hold a Seat

```http
POST /inventory/hold
```

Request:

```json
{
  "showId": 101,
  "seatId": 25
}
```

The service validates the seat and attempts to transition it from `AVAILABLE` to `HELD`.

---

## 🎯 Key Features

- Microservices-based architecture
- REST-based service communication
- OpenFeign for inter-service calls
- Temporary seat holding
- Optimistic locking using JPA `@Version`
- Transactional seat updates
- Payment workflow
- Kafka-based asynchronous events
- Notification service
- MySQL persistence

---

## 🔮 Future Enhancements

The following can be added for a production-grade implementation:

- API Gateway
- Service discovery with Eureka
- JWT authentication and authorization
- Redis-based caching
- Resilience4j circuit breakers and retries
- Kafka retry/DLQ handling
- Transactional Outbox Pattern
- Idempotency keys
- Docker containerization
- CI/CD pipeline
- AWS deployment
- Distributed tracing and monitoring

---

## 👨‍💻 Author

**Durgesh Kulkarni**

Java Backend Developer  
Java | Spring Boot | Microservices | Kafka