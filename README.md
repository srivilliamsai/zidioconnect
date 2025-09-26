# ZidioConnect – Microservices

Services:
- eureka-server (discovery)
- config-server (local)
- api-gateway
- auth-service
- system-user-service
- student-service
- recruiter-service
- jobpost-service
- application-service
- subscription-service
- payment-service
- paid-status-service
- notification-service
- fileupload-service
- analytics-service
- email-service
- admin-service

## Build
mvn clean package

## Run examples
mvn -pl eureka-server spring-boot:run
mvn -pl api-gateway spring-boot:run
