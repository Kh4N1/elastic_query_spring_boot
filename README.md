# Mobile Device Search API

A Spring Boot application that provides search functionality for mobile devices based on brand, color, and storage capacity.

## Features
- JPA/H2 database integration
- REST API endpoints
- Flexible search criteria
- Product status tracking

## Search Example
```http
POST http://localhost:8080/api/v1/devices/search
Content-Type: application/json

{
  "manufacturers": ["Apple", "Samsung"],
  "colors": ["WHITE", "SILVER"],
  "storageCapacities": [128, 256, 512]
}
```

![API Search Example](src/main/resources/API%20Search%20Example.jpg)

## Setup & Run
1. `mvn clean install`
2. `mvn spring-boot:run`
3. Access H2 console: http://localhost:8080/h2-console

## Database Configuration
```properties
spring.datasource.url=jdbc:h2:mem:devicedb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
```

## Project Structure
```
src/main/java/com/example/mobileapp/
├── controller/
│   └── DeviceController.java
├── dto/
│   ├── DeviceResponse.java
│   └── SearchCriteria.java
├── model/
│   ├── Device.java
│   └── DeviceStatus.java
├── repository/
│   └── DeviceRepository.java
├── service/
│   └── DeviceService.java
└── MobileAppApplication.java
```

## API Response Example
```json
[
  {
    "manufacturer": "Samsung",
    "model": "Galaxy S21",
    "colorCode": "WHITE",
    "storageCapacity": 256,
    "price": 899.99,
    "status": "NEW_ARRIVAL"
  }
]
```

## Technologies Used
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Lombok
- Maven