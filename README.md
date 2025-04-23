📦 CRUDBackEnd – Poste Tunisienne Backend System

A robust backend system built with **Java Spring Boot** designed to manage and streamline operations for **La Poste Tunisienne**. This application includes comprehensive modules for user management, authentication, parcel tracking, deliveries, tariffs, invoices, and regulations.

🚀 Features

- 🔐 Authentication & Authorization module
- 👤 User management (CRUD operations)
- 📦 Parcel (Colis) handling & tracking
- 📍 Depot and Delivery (Livraison) processing
- 💰 Billing (Facture) and Payments (Reglement)
- 💸 Tarification configuration and management
- 📊 Modular and scalable Spring Boot architecture

🛠 Technologies Used

- Java 11+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- RESTful APIs
- MySQL 
- Maven

🗂 Project Structure

```
src/
└── main/
    └── java/
        └── org/
            └── example/
                └── backendamen/
                    └── controller/
                        ├── AuthenticationController.java
                        ├── ColisController.java
                        ├── DepotController.java
                        ├── FactureController.java
                        ├── LivraisonController.java
                        ├── ReglementController.java
                        ├── TarificationController.java
                        └── UserController.java
```

Each controller is responsible for handling a distinct domain entity in the Tunisian postal system.

⚙️ Getting Started

Prerequisites

- Java 11 or higher
- Maven
- MySQL 
- Postman (for API testing)

Installation & Run

1. Clone the repository

```bash
git clone https://github.com/MezhoudMedIsmail/CRUDBackEnd.git
cd CRUDBackEnd
```

2. Set up the database

Create a MySQL database named `postetn` (or as configured in `application.properties`).

3. Configure application properties

In `src/main/resources/application.properties`, update the DB credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/postetn
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

4. Run the app

```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080/`.

📬 API Modules

| Module              | Endpoint Base     | Description                     |
|---------------------|-------------------|---------------------------------|
| Users               | `/api/users`      | User registration and updates   |
| Authentication      | `/api/auth`       | Login and token management      |
| Colis               | `/api/colis`      | Parcel creation and tracking    |
| Livraison           | `/api/livraison`  | Delivery updates and logs       |
| Depot               | `/api/depot`      | Deposit handling                |
| Reglement           | `/api/reglement`  | Payment tracking                |
| Facture             | `/api/facture`    | Invoice generation              |
| Tarification        | `/api/tarification`| Service pricing management      |

🔐 Authentication

Basic JWT authentication is used to secure sensitive endpoints. Tokens must be provided in the `Authorization` header:

```
Authorization: Bearer <your_token>
```

🧭 Roadmap

- ✅ CRUD operations for all main modules
- 🔒 JWT-based security
- 🧾 Invoice calculations
- 📈 Future: Dashboard & analytics integration
- 📦 Future: Integration with external postal APIs (tracking)

🤝 Contributing

Contributions are welcome! Please fork the repo and submit a pull request. For major changes, open an issue first to discuss.

---

Built with ❤️ by [MezhoudMedIsmail](https://github.com/MezhoudMedIsmail)
