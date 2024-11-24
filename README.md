# Spring Boot E-Commerce Application

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) 
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white) 
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)


This **Spring Boot E-Commerce Application** is built using Java and Spring Boot. It offers robust security with **JWT-based authentication**, ensuring a secure and scalable platform for businesses to manage and sell their products online. The application is designed for ease of maintenance and scalability, with a clean architecture and efficient handling of backend processes.



# Features
## Admin:-
- Login
- Users
- Address
- Categories
- Products
- Price & discount
- Orders
## User:-
- Registration & Login
- Fetch categories and products based on category
- Adding & deleting products to cart
- Managing address and products quantity
- Ordering products and fetching order status

# Security
- The API is secured using JSON Web Tokens (JWT) handled by Auth0. To access the API, you will need to obtain a JWT by authenticating with the /login endpoint. The JWT should then be passed in the Authorize option available in the Swagger-ui.

  ### Example:
  - Authorization: <your_jwt>

## Key Features

- **Secure Authentication**: JWT is used to manage user authentication and authorization.
- **Role-Based Access**: Different levels of access for users and administrators.
- **Product Management**: CRUD operations for products and categories.
- **User Management**: Registration and login with encrypted password storage.
- **Order Management**: Track and manage customer orders.
- **RESTful APIs**: Built with scalability and maintainability in mind.

---

## Technology Stack

- **Backend Framework**: Spring Boot 3.3
- **Security**: Spring Security and JWT
- **Database**: MySQL (Spring Data JPA and Hibernate)
- **Build Tool**: Maven
- **Programming Language**: Java 17+
- **API Design**: RESTful

---

## Getting Started

### Prerequisites

1. Install **Java 17** or higher.
2. Install **Maven**.
3. Set up a MySQL database and note the credentials.

---

# ER-Diagram
<img width="605" alt="ER-Diagram" src="https://github.com/sakthiram2004/Spring-Boot-Ecommerce-Application/blob/d6a84c9e6a032d3367f1bd08b76cfa2d5ae647f9/Screenshot%202024-11-17%20211615.png">



## Thank You

