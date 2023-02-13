# Payments Management
This project runs with Spring Boot 3.0.2 and Java 17.

##Build
From the root folder run `mvn clean install`

## Run the application
Run `mvn spring-boot:run`

Payments API url: http://localhost:8080/api/payments 

## Create new Payment - Request Body
Example of request body
```
{
    "payerEmail": "john.smith@gmail.com",
    "amount": 250,
    "currency": "GBP"
}
```
