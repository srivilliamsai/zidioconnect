# 💻 ZidioConnect Backend Microservices

This repository contains the backend source code for the ZidioConnect Job Portal, implemented as a **Spring Cloud Microservices Architecture**. All services are developed in Java, communicate via Eureka, and are secured using JWT.

## 🧱 Project Architecture & Technology Stack

The system is composed of 16 highly specialized services. All communication is routed through the central **API Gateway**.

### Core Technologies
| Component | Technology | Role |
| :--- | :--- | :--- |
| **Language** | Java 8/11 (Spring Boot 2.7.x) | Primary development language. |
| **Persistence** | MySQL / Spring Data JPA | Relational Database for all data persistence. |
| **Discovery** | Eureka Server | Centralized Service Registry (Service IPs/Ports). |
| **Routing** | API Gateway (8080) | Single entry point for the frontend; handles security and load balancing. |
| **Configuration** | Config Server (8888) | Centralized management of configuration files (YAML/Properties). |
| **Security** | JWT (JSON Web Tokens) | Stateless authentication and cross-service authorization. |

### Service Map
| Service Name | Port | Function |
| :--- | :--- | :--- |
| **AUTH-SERVICE** | `8081` | Handles User Registration, Login, and JWT Token Issuance. |
| **API-GATEWAY** | `8080` | External Access Point / Router. |
| **CONFIG-SERVER** | `8888` | Configuration Source for all services. |
| **RECRUITER-SERVICE** | `8085` | Recruiter Profile and Management (Optimized Search). |
| **STUDENT-SERVICE** | `8083` | Student Profile and Management (Optimized Caching). |
| **ADMIN-SERVICE** | `8090` | Admin CRUD and System Oversight. |
| **SYSTEM-USER-SERVICE**| `8082` | Core User Management for Admins. |
| **JOBPOST-SERVICE** | `8084` | Job Creation and Listing. |
| **APPLICATION-SERVICE**| `8086` | Application Submission and Tracking. |
| **ANALYTICS-SERVICE** | `8093` | Metrics and Reporting. |
| **EMAIL-SERVICE** | `8094` | Asynchronous Email Sending. |
| **FILEUPLOAD-SERVICE**| `8092` | Resume/File Storage. |
| **(Other Services)** | `8087-8091` | Subscription, Payment, Paid-Status, Notification, Employee services. |

## 🛠️ Local Development Setup

To run the full microservice suite, services **must** be started in the correct sequence.

### 1. Prerequisites Check
* **Java 8/11+** and **Maven** installed.
* **MySQL Server** running with the correct database schema created (e.g., `authdb`, `recruiterdb`, etc.).
* **Internet connection** (to fetch configurations from the Config Server's Git Repo).

### 2. Startup Sequence (The Golden Rule)

Use `cd <service-name>` followed by `mvn spring-boot:run` for each service.

1.  **START INFRASTRUCTURE FIRST (Required):**
    * **1. Eureka Server:** Start the `eureka-server` (`:8761`).
    * **2. Config Server:** Start the `config-server` (`:8888`).

2.  **START GATEWAY & AUTHENTICATION:**
    * **3. Auth Service:** Start the `auth-service` (`:8081`). (Issues JWTs).
    * **4. API Gateway:** Start the `api-gateway` (`:8080`). (Entry Point).

3.  **START FUNCTIONAL SERVICES:**
    * **5. Start All Remaining Services:** (`recruiter-service`, `student-service`, `admin-service`, etc.).

## 🔐 Testing and Security

All tests must be conducted via the **API Gateway** on port **8080**.

1.  **Authentication:** Use `POST /api/auth/register?role=ROLE_ADMIN` to get a fresh token.
2.  **Access:** Use the **Bearer Token** for all subsequent calls. The authorization for each service is enforced by the **`@PreAuthorize`** annotations (`hasAuthority('ROLE_ADMIN')`, etc.) that are enabled in every service's `SecurityConfig.java`.

---