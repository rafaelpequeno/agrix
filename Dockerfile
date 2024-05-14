FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

COPY . .
RUN ./mvnw clean package

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]