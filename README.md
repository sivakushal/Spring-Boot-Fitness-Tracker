## Spring-Boot-Fitness-Tracker
This project is a fully functional backend application built using Java Spring Boot that exposes REST APIs for creating, reading, updating, and deleting resources.It demonstrates real-world backend development principles including layered architecture, exception handling, database persistence, and RESTful design.
## Project Overview

This project is a **Spring Boot REST API** that performs **CRUD (Create, Read, Update, Delete)** operations on entities stored in a relational database.  
It follows industry-standard backend practices such as clean architecture, separation of concerns, and proper exception handling.

The goal of this project is to gain **hands-on experience with backend development**, understand how real APIs are built, and learn how Spring Boot simplifies enterprise application development.

---

## Tech Stack

- **Java** (17+)
- **Spring Boot**
- **Spring Web (REST APIs)**
- **Spring Data JPA**
- **Hibernate**
- **MySQL / H2 Database**
- **Maven**
- **Postman** (API testing)

---

## Features

- RESTful API development
- CRUD operations
- Spring Boot auto-configuration
- Layered architecture (Controller → Service → Repository)
- Database persistence using JPA & Hibernate
- Exception handling with meaningful responses
- Clean and readable code structure

---
## Sample Request

POST /api/items
```json
{
  "name": "Spring Boot Course",
  "price": 499.99
}


