## Running the Project with Docker

This project provides a Docker-based setup for building and running the Java Spring Boot application. The setup uses multi-stage builds for efficient image creation and includes a Docker Compose file for easy orchestration.

### Project-Specific Docker Requirements
- **Base Image:** Uses `eclipse-temurin:21-jdk` for building and `eclipse-temurin:21-jre` for running the application (Java 21 required).
- **Build Tool:** Maven Wrapper (`mvnw`) is used for building the project inside the container.
- **Non-root User:** The runtime container runs as a non-root user (`appuser`) for improved security.

### Environment Variables
- No required environment variables are specified by default in the Dockerfile or `docker-compose.yml`.
- If your application requires environment variables, you can add them to a `.env` file and uncomment the `env_file` line in `docker-compose.yml`.

### Build and Run Instructions
1. **Build and Start the Application:**
   ```sh
   docker-compose up --build
   ```
   This command builds the Docker image and starts the `java-app` service.

2. **Accessing the Application:**
   - The application is exposed on port **8080**. Access it at: [http://localhost:8080](http://localhost:8080)

### Special Configuration
- **Database:**
  - The `docker-compose.yml` includes commented-out configuration for a PostgreSQL service. If your application requires a database, uncomment and configure the `postgres` service and related settings.
- **Custom JVM Options:**
  - The container runs the application with `-XX:MaxRAMPercentage=80.0` for container-aware memory management.

### Ports
- **java-app:** Exposes port **8080** (container) to **8080** (host).
- **Database:** If enabled, the default PostgreSQL port is **5432** (see commented section in `docker-compose.yml`).

---

_This section was updated to reflect the current Docker and Docker Compose setup for this project. For more details on Kubernetes or Minikube deployment, see the respective `Minikube-readme.txt` and Helm chart files._
