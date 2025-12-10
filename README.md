# Smart Inventory Management System (Oracle Version)

Tech stack:
- Spring Boot 3
- Spring Web, Spring Data JPA, Spring Security
- JWT authentication
- Oracle Database (ojdbc11)
- Java 17

## How to run

1. Create Oracle user and schema, for example:

   ```sql
   CREATE USER INVENTORY_USER IDENTIFIED BY INVENTORY_PASSWORD;
   GRANT CONNECT, RESOURCE TO INVENTORY_USER;
   ```

2. Update `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password`
   in `src/main/resources/application.properties` if needed.

3. Build and run:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Test APIs (example with Postman):

   - `POST /api/auth/register` with JSON `{ "username": "admin", "password": "admin123" }`
   - `POST /api/auth/login` to get JWT
   - Use `Authorization: Bearer <token>` header for `/api/products/**` endpoints.
