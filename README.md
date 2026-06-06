# Logistics & Shipment Tracking System

A backend REST API built using Spring Boot, Spring Security (JWT), Spring Data JPA, Hibernate, and MySQL for managing logistics operations including customers, drivers, warehouses, shipments, shipment tracking, and role-based authentication.

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

---

## Features

### Authentication

- User Registration
- User Login
- JWT Token Generation
- BCrypt Password Encoding
- Role Based Authorization

### Customer Management

- Create Customer
- Get Customer By Id
- Get All Customers
- Delete Customer

### Driver Management

- Create Driver
- Get Driver By Id
- Get All Drivers
- Delete Driver

### Warehouse Management

- Create Warehouse
- Get Warehouse By Id
- Get All Warehouses
- Delete Warehouse

### Shipment Management

- Create Shipment
- Get Shipment By Id
- Get All Shipments
- Delete Shipment
- Update Shipment Status

### Tracking Management

- Store Shipment Tracking History
- View Shipment Tracking History

### User Management

- Register User
- Login User
- Get All Users
- Get User By Id

---

# Project Structure

```
src
└── main
    ├── java
    │
    └── com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS
        │
        ├── config
        │   ├── PasswordConfig.java
        │   └── SecurityConfig.java
        │
        ├── controller
        │   ├── AuthController.java
        │   ├── CustomerController.java
        │   ├── DriverController.java
        │   ├── ShipmentController.java
        │   ├── UserController.java
        │   └── WarehouseController.java
        │
        ├── dto
        │   │
        │   ├── Request
        │   │   ├── CreateCustomerRequest.java
        │   │   ├── CreateDriverRequest.java
        │   │   ├── CreateShipmentRequest.java
        │   │   ├── CreateWarehouseRequest.java
        │   │   ├── LoginRequest.java
        │   │   ├── RegisterRequest.java
        │   │   └── UpdateShipmentStatusRequest.java
        │   │
        │   └── Response
        │       └── AuthResponse.java
        │
        ├── entity
        │   ├── Customer.java
        │   ├── Driver.java
        │   ├── Shipment.java
        │   ├── TrackingHistory.java
        │   ├── Users.java
        │   └── Warehouse.java
        │
        ├── enums
        │   ├── Role.java
        │   └── ShipmentStatus.java
        │
        ├── exception
        │   ├── ErrorResponse.java
        │   ├── GlobalExceptionHandler.java
        │   └── NotFoundException.java
        │
        ├── repository
        │   ├── CustomerRepository.java
        │   ├── DriverRepository.java
        │   ├── ShipmentRepository.java
        │   ├── TrackingHistoryRepository.java
        │   ├── UserRepository.java
        │   └── WarehouseRepository.java
        │
        ├── security
        │   ├── JwtFilter.java
        │   ├── JwtUtil.java
        │   └── UserCustomDetailsService.java
        │
        ├── service
        │   ├── AuthService.java
        │   ├── CustomerService.java
        │   ├── DriverService.java
        │   ├── ShipmentService.java
        │   ├── UserService.java
        │   └── WarehouseService.java
        │
        ├── ServiceImpl
        │   ├── AuthServiceImpl.java
        │   ├── CustomerServiceImpl.java
        │   ├── DriverServiceImpl.java
        │   ├── ShipmentServiceImpl.java
        │   ├── UserServiceImpl.java
        │   └── WarehouseServiceImpl.java
        │
        └── Application.java
```

---

# Entity Relationship

```
Customer
    │
    │ One To Many
    ▼
Shipment

Driver
    │
    │ One To Many
    ▼
Shipment

Shipment
    │
    │ One To Many
    ▼
TrackingHistory

Shipment
    │
    │ Many To Many
    ▼
Warehouse

Users
    │
    ▼
Role (ADMIN | MANAGER | EMPLOYEE | USER)
```

---

# API Endpoints

## Authentication

```
POST   /api/auth/register
POST   /api/auth/login
```

## Customer

```
POST   /api/customer
GET    /api/customer
GET    /api/customer/{id}
DELETE /api/customer/{id}
```

## Driver

```
POST   /api/driver
GET    /api/driver
GET    /api/driver/{id}
DELETE /api/driver/{id}
```

## Shipment

```
POST   /api/shipment
GET    /api/shipment
GET    /api/shipment/{id}
DELETE /api/shipment/{id}
PATCH  /api/shipment/{id}/status
```

## Warehouse

```
POST   /api/warehouse
GET    /api/warehouse
GET    /api/warehouse/{id}
DELETE /api/warehouse/{id}
```

## Users

```
GET    /api/users
GET    /api/users/{id}
```

---

# Authentication

Protected APIs require a Bearer Token.

```
Authorization: Bearer <JWT_TOKEN>
```

---

# Role Based Access

| Module | ADMIN | MANAGER | EMPLOYEE | USER |
|------------|:----:|:----:|:----:|:----:|
| Register/Login | ✓ | ✓ | ✓ | ✓ |
| Users | ✓ | ✗ | ✗ | ✗ |
| Customer | ✗ | ✓ | ✗ | ✗ |
| Driver | ✓ | ✓ | ✗ | ✗ |
| Shipment | ✗ | ✓ | ✗ | ✗ |
| Warehouse | ✓ | ✓ | ✓ | ✗ |

---

# Business Logic

### Shipment Creation

- Customer must exist
- Driver must exist
- Warehouse must exist
- Tracking number generated automatically
- Default shipment status is **PENDING**
- Created date generated automatically

### Shipment Status Update

```
PENDING
    │
    ▼
PICKED_UP
    │
    ▼
IN_TRANSIT
    │
    ▼
OUT_FOR_DELIVERY
    │
    ▼
DELIVERED
```

Every status update creates a Tracking History record.

---

# Database Tables

```
users

customer

driver

shipment

tracking_history

warehouse

shipment_warehouse
```
  
# Learning Concepts

- REST API Development
- Layered Architecture
- DTO Pattern
- Repository Pattern
- Service Layer
- Exception Handling
- OneToMany Mapping
- ManyToOne Mapping
- ManyToMany Mapping
- Enum Mapping
- JWT Authentication
- Spring Security
- BCrypt Password Encoding
- Role Based Authorization
- Spring Data JPA
- Hibernate ORM
- MySQL Integration

---

# Author

**Abhiram Bhatt**

Backend project developed to practice enterprise-level Spring Boot architecture, secure REST APIs, entity relationships, and JWT-based authentication.
