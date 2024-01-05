# Get Updated App

## Overview

The Get Updated App is a Spring Boot project, implemented in Java, that serves as a backend application providing real-time updates from external APIs. The project emphasizes security by incorporating Spring Security, JWT (JSON Web Tokens), OAuth, and ensures efficient data handling through JPA Hibernate and MySQL. Additionally, user engagement is enhanced with features such as comments and likes, facilitating a comprehensive user experience.

## Technologies Used

- Spring Boot
- Spring Security
- Java
- JWT (JSON Web Tokens)
- OAuth
- JPA (Hibernate)
- Cloudionary
- MySQL

## Features

1. **Real-Time Updates**: The application fetches real-time updates from external APIs, ensuring that users stay informed with the latest information.

2. **Security**: Robust security measures are implemented using Spring Security, JWT, and OAuth to safeguard user data and authentication processes.

3. **Efficient Data Handling**: The project employs JPA Hibernate and MySQL for efficient and seamless handling of data, ensuring smooth API integration with Retrofit Networking.

4. **User-Generated Content**: Users can create and share their posts in various topics, contributing to a dynamic and diverse content ecosystem.

5. **User Engagement**: The application includes features like comments and likes, fostering user interaction and engagement. Proper entity mapping is implemented to facilitate a rich user experience.

## Setup

1. **Clone the repository:**

   ```shell
   git clone https://github.com/Harsh-Srivastav123/Get-Updated.git
2. **Configure application.properties:**
   ```shell
     # configure according to your requirement 
     server.port=8080
     spring.datasource.url=url
     spring.datasource.username="username"
     spring.datasource.password="password"
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.generate-ddl=true
     spring.jpa.show.sql=true
     spring.jpa.format.sql=true
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
     spring.servlet.multipart.max-file-size=10MB
     spring.servlet.multipart.max-request-size=10MB
3. **Configure Cloudinary Configuration**
   ```shell
     config.put("cloud_name","");
     config.put("api_key","");
     config.put("api_secret","");
     config.put("sceure",true); 
     

4. **Access the Application**: Once the application is running, access it through [http://localhost:8080](http://localhost:8080) in your web browser.

## Contributing

Contributions are welcome! If you would like to contribute to the project, please follow the standard GitHub fork and pull request workflow.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code for your own purposes.
