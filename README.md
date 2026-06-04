# 🚀 Loveable - AI-Powered Project Generation Platform

<div align="center">

[![Java 21](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Node.js](https://img.shields.io/badge/Node.js-18+-green.svg)](https://nodejs.org/)
[![Kubernetes](https://img.shields.io/badge/Kubernetes-Ready-blue.svg)](https://kubernetes.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**An enterprise-grade SaaS platform that leverages AI to generate, manage, and deploy full-stack applications with a single prompt.**

</div>

---

## 📖 Table of Contents

- [Overview](#overview)
- [Key Features](#key-features)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

Loveable is a cutting-edge SaaS platform that revolutionizes how developers create applications. By combining the power of OpenAI's GPT models with a sophisticated microservices architecture, Loveable enables users to generate complete, production-ready projects from simple natural language descriptions.

The platform provides:
- 🤖 **AI-Powered Code Generation** - Transform ideas into functional code
- 💳 **Subscription Management** - Integrated Stripe billing system
- 🌐 **Real-time Deployment** - Kubernetes-native deployment pipeline
- 💬 **AI Assistant Chat** - Interactive guidance throughout development
- 📦 **Object Storage** - MinIO integration for file management
- 🔐 **Enterprise Security** - JWT-based authentication & authorization

---

## ✨ Key Features

### 🤖 AI-Powered Development
- **Intelligent Project Generation**: Create full-stack applications from natural language prompts
- **Multi-model AI Support**: GPT-5.4, GPT-5.2, and specialized code generation models
- **Context-aware Chat Assistant**: Real-time AI guidance and code explanations
- **Smart Code Parsing**: Automated response parsing and validation

### 🏗️ Project Management
- **CRUD Operations**: Full project lifecycle management
- **Soft Delete**: Safe project archival with recovery options
- **Database Optimization**: Indexed queries for enhanced performance
- **Project Templates**: Pre-configured starter templates

### 💳 Subscription & Billing
- **Multi-tier Plans**: Free, Pro, and Enterprise subscription levels
- **Stripe Integration**: Secure payment processing
- **Usage Tracking**: Comprehensive analytics and monitoring
- **Plan Management**: Upgrade/downgrade with prorated billing

### 🚀 Deployment & Infrastructure
- **Kubernetes Native**: Production-ready K8s manifests
- **Containerized Services**: Docker support for all components
- **Wildcard Proxy**: Dynamic routing for project previews
- **Redis Caching**: High-performance session and data caching

### 🔒 Security & Authentication
- **JWT Authentication**: Stateless, secure token-based auth
- **Role-Based Access Control**: Granular permission management
- **Custom Security Expressions**: Fine-grained access control
- **Password Encryption**: BCrypt hashing for user credentials

### 📊 Analytics & Monitoring
- **Usage Logging**: Comprehensive activity tracking
- **Chat Session Management**: AI conversation history
- **Real-time Metrics**: Performance and usage analytics
- **Database Indexing**: Optimized query performance

---

## 🏗️ Architecture

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Client App    │    │  Load Balancer  │    │  API Gateway    │
│  (React/Vue/Angular) │◄───►│   (Nginx)      │◄───►│  (Spring Cloud)│
└────────┬────────┘    └────────┬────────┘    └────────┬────────┘
         │                      │                      │
         └──────────────────────┼──────────────────────┘
                                │
         ┌──────────────────────┴──────────────────────┐
         │          Microservices Architecture          │
         └──────────────────────┬──────────────────────┘
                                │
    ┌───────────────────────────┼───────────────────────────┐
    │                           │                           │
┌───▼────┐    ┌────────┐    ┌─▼───┐    ┌──────────┐    ┌─▼───┐
│  Auth  │    │ Project│    │ Chat│    │  Billing │    │Proxy│
│ Service│    │ Service│    │Service│  │  Service │    │Service│
└───┬────┘    └───┬────┘    └───┬───┘    └───┬──────┘    └──┬──┘
    │             │             │            │              │
    └──────┬──────┴──────┬──────┴──────┬───┴──────┬───────┴──────┬
           │             │             │          │              │
       ┌───▼───┐     ┌──▼───┐     ┌──▼──┐   ┌──▼───┐      ┌──▼────┐
       │PostgreSQL│   │ Redis │   │MinIO│   │Stripe│      │Kubernetes│
       │(pgvector)│   │       │   │     │   │      │      │          │
       └─────────┘   └───────┘   └─────┘   └──────┘      └──────────┘
```

### Core Components

1. **API Gateway**: Spring Boot application serving as the main entry point
2. **Wildcard Proxy**: Node.js service for dynamic project preview routing
3. **PostgreSQL**: Primary database with pgvector extension for AI embeddings
4. **Redis**: Caching layer and session storage
5. **MinIO**: S3-compatible object storage for project files
6. **Kafka**: Message streaming (configured for future event-driven features)

---

## 🛠️ Tech Stack

### Backend
- **Java 21**: Modern Java with records, pattern matching, and virtual threads
- **Spring Boot 4.0.0**: Latest Spring ecosystem
- **Spring Data JPA**: Database abstraction layer
- **Spring Security**: Authentication and authorization
- **Spring AI**: Integration with OpenAI models
- **MapStruct**: Object mapping
- **Lombok**: Reduce boilerplate code
- **JJWT**: JSON Web Token handling

### Frontend
- **Node.js 18+**: Proxy service runtime
- **HTTP Proxy**: Dynamic routing middleware
- **ioredis**: Redis client for Node.js

### Database & Storage
- **PostgreSQL 18**: Primary relational database
- **pgvector 0.8.1**: Vector similarity search for AI embeddings
- **Redis 7+**: In-memory data store
- **MinIO**: S3-compatible object storage

### Infrastructure
- **Docker & Docker Compose**: Container orchestration
- **Kubernetes**: Production deployment platform
- **Helm**: Kubernetes package manager (ready for integration)

### AI/ML
- **OpenAI GPT-5.4**: Primary language model
- **OpenAI Embeddings**: text-embedding-3-small for vector search
- **Spring AI**: Simplified AI integration

### Payment Processing
- **Stripe Java SDK**: Secure payment processing

### API Documentation
- **SpringDoc OpenAPI**: Auto-generated API documentation

---

## 📋 Prerequisites

- **Java 21** or higher
- **Maven 3.9+**
- **Node.js 18+** and **npm 9+**
- **Docker & Docker Compose**
- **Kubernetes cluster** (for production deployment)
- **OpenAI API Key**
- **Stripe Account & API Keys**

---

## 🔧 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/loveable.git
cd loveable
```

### 2. Start Infrastructure Services

```bash
# Start PostgreSQL, Redis, MinIO, and Kafka
docker-compose -f services.docker-compose.yml up -d
```

### 3. Configure Environment

Create `application-keys.yaml` in `src/main/resources/`:

```yaml
openai:
  api-key: "your-openai-api-key-here"

stripe:
  secret-key: "your-stripe-secret-key-here"
  webhook-secret: "your-stripe-webhook-secret-here"
```

### 4. Build the Application

```bash
# Make Maven wrapper executable
chmod +x mvnw

# Build the project
./mvnw clean package
```

### 5. Start the Proxy Service

```bash
cd proxy
npm install
npm start
```

### 6. Run the Application

```bash
# Run with Maven
./mvnw spring-boot:run

# Or run the JAR
java -jar target/loveable-0.0.1-SNAPSHOT.jar
```

---

## ⚙️ Configuration

### Application Properties

Key configurations in `application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:9010/lovableDB
    username: user
    password: password
  
  ai:
    openai:
      chat:
        options:
          model: gpt-5.4-2026-03-05
      embedding:
        options:
          model: text-embedding-3-small

jwt:
  secret-key: your-jwt-secret-key-here

minio:
  url: http://localhost:9000
  access-key: minioadmin
  secret-key: minioadmin123
  project-bucket: projects
```

### Kubernetes Configuration

The `k8s/` directory contains production-ready manifests:

- `infra.yml`: Infrastructure components (PostgreSQL, Redis, MinIO)
- `runner-pods.yml`: Application deployment
- `shuttle-proxy.yml`: Proxy service deployment
- `policy.yml`: Security policies

### Docker Compose Services

- **PostgreSQL with pgvector**: `localhost:9010`
- **Redis**: `localhost:6379`
- **MinIO API**: `localhost:9000`
- **MinIO Console**: `localhost:9001`
- **Kafka**: `localhost:29092`

---

## 🚀 Usage

### API Endpoints

#### Authentication
```http
POST /api/auth/signup
POST /api/auth/signin
POST /api/auth/refresh
```

#### Projects
```http
GET    /api/projects              # List user projects
GET    /api/projects/{id}         # Get project details
POST   /api/projects              # Create new project
PATCH  /api/projects/{id}         # Update project
DELETE /api/projects/{id}         # Soft delete project
POST   /api/projects/{id}/deploy  # Deploy project
```

#### AI Chat
```http
POST /api/chat/sessions          # Create chat session
POST /api/chat/messages          # Send message to AI
GET  /api/chat/sessions/{id}     # Get session messages
```

#### Billing
```http
GET    /api/billing/plans        # List available plans
POST   /api/billing/subscribe    # Create subscription
GET    /api/billing/subscription # Get current subscription
```

### Example: Creating a Project

```bash
curl -X POST http://localhost:8082/api/projects \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "My E-Commerce App",
    "description": "Create a modern e-commerce platform with React and Node.js",
    "template": "react-vite"
  }'
```

### Example: AI Chat Session

```bash
curl -X POST http://localhost:8082/api/chat/sessions \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "projectId": 123,
    "message": "How do I add authentication to my project?"
  }'
```

---

## 📚 API Documentation

Once the application is running, access the interactive API documentation:

- **Swagger UI**: http://localhost:8082/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8082/v3/api-docs

---

## 📁 Project Structure

```
loveable/
├── src/main/java/com/codingShuttle/loveable/loveable/
│   ├── LoveableApplication.java          # Main application class
│   ├── config/                           # Configuration classes
│   │   ├── AIConfig.java                   # OpenAI configuration
│   │   ├── CorsConfig.java                 # CORS settings
│   │   ├── KubernetesConfig.java           # K8s client config
│   │   ├── RedisConfig.java                # Redis configuration
│   │   └── StorageConfig.java              # MinIO configuration
│   ├── controller/                         # REST controllers
│   │   ├── AuthController.java           # Authentication endpoints
│   │   ├── ProjectController.java        # Project management
│   │   ├── ChatController.java           # AI chat endpoints
│   │   └── BillingController.java        # Payment processing
│   ├── entity/                           # JPA entities
│   │   ├── User.java                       # User model
│   │   ├── Project.java                    # Project model
│   │   ├── ChatSession.java                # Chat session tracking
│   │   └── Subscription.java               # Subscription management
│   ├── repository/                       # Data access layer
│   ├── service/                          # Business logic
│   │   ├── impl/                           # Service implementations
│   │   ├── AIGenerationService.java        # AI code generation
│   │   ├── ProjectService.java             # Project operations
│   │   └── PaymentProcessorService.java    # Stripe integration
│   ├── security/                         # Security components
│   │   ├── JwtAuthFilter.java              # JWT authentication
│   │   ├── WebSecurityConfig.java        # Security configuration
│   │   └── SecurityExpressions.java        # Custom security expressions
│   ├── dto/                              # Data transfer objects
│   │   ├── auth/                           # Authentication DTOs
│   │   ├── chat/                           # Chat-related DTOs
│   │   ├── deploy/                         # Deployment DTOs
│   │   └── project/                        # Project DTOs
│   ├── mapper/                           # MapStruct mappers
│   ├── enums/                            # Enumerations
│   └── error/                            # Error handling
├── proxy/                                # Node.js wildcard proxy
│   ├── index.js                            # Proxy server
│   └── package.json                        # Node.js dependencies
├── k8s/                                  # Kubernetes manifests
│   ├── infra.yml                           # Infrastructure
│   ├── runner-pods.yml                     # Application pods
│   └── shuttle-proxy.yml                   # Proxy deployment
├── services.docker-compose.yml           # Local infrastructure
├── pom.xml                               # Maven configuration
└── README.md                             # This file
```

---

## 🚢 Deployment

### Local Development

```bash
# Start all services
docker-compose -f services.docker-compose.yml up -d

# Run the application
./mvnw spring-boot:run

# Start proxy
cd proxy && npm start
```

### Docker Deployment

```bash
# Build Docker image
docker build -t loveable:latest .

# Run container
docker run -p 8082:8082 loveable:latest
```

### Kubernetes Deployment

```bash
# Apply infrastructure
kubectl apply -f k8s/infra.yml

# Deploy application
kubectl apply -f k8s/runner-pods.yml

# Deploy proxy
kubectl apply -f k8s/shuttle-proxy.yml
```

### Production Checklist

- [ ] Configure production database
- [ ] Set up SSL/TLS certificates
- [ ] Configure custom domain
- [ ] Set up monitoring and logging
- [ ] Configure backup strategies
- [ ] Implement rate limiting
- [ ] Set up CI/CD pipeline
- [ ] Configure autoscaling
- [ ] Set up Redis Sentinel/Cluster
- [ ] Configure PostgreSQL replication

---

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/amazing-feature`
3. **Commit** your changes: `git commit -m 'Add amazing feature'`
4. **Push** to the branch: `git push origin feature/amazing-feature`
5. **Open** a Pull Request

### Development Guidelines

- Follow Java 21 best practices and Spring Boot conventions
- Write unit tests for new features
- Update documentation as needed
- Ensure code passes all checks: `./mvnw clean verify`
- Use conventional commit messages

### Code Style

```bash
# Format code
./mvnw spotless:apply

# Check style
./mvnw checkstyle:check
```

---

## 📞 Support

- **Documentation**: [docs.loveable.dev](https://docs.loveable.dev)
- **Issues**: [GitHub Issues](https://github.com/yourusername/loveable/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/loveable/discussions)
- **Email**: support@loveable.dev

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- [Spring AI](https://spring.io/projects/spring-ai) for AI integration
- [Stripe](https://stripe.com) for payment processing
- [Kubernetes](https://kubernetes.io) for container orchestration
- [OpenAI](https://openai.com) for AI models
- [pgvector](https://github.com/pgvector/pgvector) for vector similarity search

---

<div align="center">

**⭐ Star this repo if you find it helpful!**

Made with ❤️ by [Coding Shuttle](https://codingshuttle.com)

</div>