# JWT Authentication

> <p> A backend project focused on implementing user authentication and authorization using the Spring Boot framework. It provides a REST API for user login and signup functionality, with security features and web tokens (JWT) for authentication. </p>

<div align="center">
  
![banner](https://github.com/sahu-neha/Backend-Authentication-SpringBoot/assets/109987397/67c41bb9-e59b-4ba2-a1e7-50cbbb69f2d0)

</div>


> ## Table of Contents

- [Features](#features)
- [Tech-Stack](#tech-stack)
- [Dependencies](#dependencies)
- [Prerequisites](#prerequisites)
- [Setting & Installation](#setting--installation)
- [URL](#url)


> ## Features

- User signup: Users can create new accounts by providing their details such as name, email, and password. The user information is securely stored in the H2 database.

- User login: Users can authenticate themselves by providing their credentials (email and password) through the login endpoint. Upon successful authentication, a web token is generated and returned.

- JWT-based authentication: The application uses JSON Web Tokens (JWT) to authenticate and authorize users. The generated token is required to access protected resources, ensuring that only authenticated users can access them.


> ## Tech-Stack

- JAVA
- SPRING
- SPRINGBOOT
- MAVEN
- H2 DATABASE
- POSTMAN

  
> ## Dependencies

- SPRING DATA JPA
- SPRING BOOT DEVTOOLS
- SPRING WEB
- SPRING SECURITY
- H2 DATABASE
- VALIDATION
- LOMBOK
- JWT API
- JWT IMPL
- JWT JACKSON


> ## Prerequisites

Before running the application, make sure you have the following installed:

- Java
- Java IDE (preferably Spring Tool Suite)


> ## Setting & Installation 

Install the `Spring Tool Suite` (STS)

```bash
https://spring.io/tools
```

Clone the Repository

```bash
git clone https://github.com/sahu-neha/Backend-Authentication-SpringBoot.git
```

> ## Run Locally

Go to the Project Directory

```bash
Open the Backend_for_login_signup Folder with STS
```

Go to **src/main/resources > application.properties** & change your SpringBoot username and password
</br>
(By default, Spring Boot configures the application to connect to an in-memory store with the username "sa" and an empty password)

```bash
spring.datasource.username=sa
spring.datasource.password=password
```

To change the **Server Port**

```bash
server.port=8080
```

Go to **com.masai package > BackendForLoginSignupApplication.java**

```bash
Run as Spring Boot App (Alt+Shift+X, B)
```

> ## URL

Open Postman and navigate to the following URLs:

1. Home:

   **Method**: `GET`
   ```bash
   http://localhost:8080/user
   ```

2. User Signup:

   ```bash
   http://localhost:8080/user/signup
   ```
   **Method**: `POST` </br>
   **Request Body**:
   ```json
   {
    "firstName": "fName",
    "lastName": "lName",
    "email": "email@example.com",
    "password": "@password"
   }
   ```

3. Admin Signup:

   ```bash
   http://localhost:8080/user/signup/{secretKey}
   ```
   Replace `{secretKey}` with the actual secret key value.

   **Method**: `POST` </br>
   **Request Body**:
   ```json
   {
    "firstName": "fName",
    "lastName": "lName",
    "email": "email@example.com",
    "password": "@password"
   }
   ```

4. User Login:
   
   ```bash
   http://localhost:8080/user/userLogin
   ```
   **Method**: `GET` </br>
   **Request Body**:
   ```json
   {
    "email": "email@example.com",
    "password": "@password"
   }
   ```

5. Admin Login:
   
   ```bash
   http://localhost:8080/user/adminLogin
   ```
   **Method**: `GET` </br>
   **Request Body**:
   ```json
   {
    "email": "email@example.com",
    "password": "@password"
   }
   ```

These URLs represent different endpoints of the backend API. By running them you can interact with the corresponding functionalities of the application.


> ## Conclusion

This backend project provides user authentication and authorization using Spring Boot, with features such as user signup, login, and JWT-based authentication.
