# Example Project: Java Spring Fullstack

**Stack:**

- Java 8
- Maven 3 
- Spring Boot 2
- Spring Web
- Spring Data
- MongoDB
- JUnit 5
- Lombok

[Support References](REFERENCE.md)

### Setup Development 
---------------------

1. Up Container Docker
2. Run project through IDE

```
docker run -d --name docker-mongo \
    -e MONGO_INITDB_ROOT_USERNAME=dev \
    -e MONGO_INITDB_ROOT_PASSWORD=dev \
    -e MONGO_INITDB_DATABASE=dev \
    -p 27017:27017 mongo:latest
```