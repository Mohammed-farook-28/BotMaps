# Bot Travel Application

## Overview
The **Bot Travel Application** is a backend service designed to help users manage their travel experiences, including visited countries, notes, photos, and people they have met during their travels. The application leverages MongoDB as its database and provides RESTful APIs for managing users, countries, and user-specific travel data.

---

## Features

### User Management
- Add, retrieve, and update user details.
- Manage user-specific travel data.

### Country Management
- Add, update, retrieve, and delete country details.
- Store detailed information about countries, including descriptions, popular destinations, travel tips, and currency details.

### User-Country Management
- Track countries a user has visited.
- Add notes and photos for specific countries.
- Manage people met in different countries with details like contact information and social media profiles.
- Retrieve aggregated information about people met by nationality or country.

### Additional Features
- Swagger UI integration for easy API testing.
- MongoDB for flexible data storage.

---

## Technologies Used
- **Java**: Backend programming language.
- **Spring Boot**: Framework for developing the backend application.
- **MongoDB**: Database for storing application data.
- **Swagger UI**: API documentation and testing.
- **Maven**: Build and dependency management tool.

---

## API Endpoints

### User Endpoints
- **GET** `/users/{userId}`: Retrieve user details.
- **POST** `/users`: Add a new user.
- **PUT** `/users/{userId}`: Update user details.

### Country Endpoints
- **GET** `/countries`: Retrieve all countries.
- **GET** `/countries/{code}`: Retrieve country details by code.
- **POST** `/countries`: Add a new country.
- **PUT** `/countries/{code}`: Update country details.
- **DELETE** `/countries/{code}`: Delete a country.

### User-Country Endpoints
- **GET** `/user-countries/{userId}/visited`: Retrieve all visited countries for a user.
- **PATCH** `/user-countries/{userId}/toggle/{countryCode}`: Toggle the visited status of a country for a user.
- **PATCH** `/user-countries/{userId}/{countryCode}/notes`: Add or update notes for a country.
- **POST** `/user-countries/{userId}/{countryCode}/photos`: Add photos for a country.
- **POST** `/user-countries/{userId}/{countryCode}/people`: Add a person met in a specific country.
- **GET** `/user-countries/{userId}/people`: Retrieve all people a user has met across all countries.
- **GET** `/user-countries/{userId}/people/{countryCode}`: Retrieve people a user met in a specific country.

---

## Getting Started

### Prerequisites
1. Java 17 or higher.
2. Maven.
3. MongoDB instance (e.g., MongoDB Atlas).

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/bot-travel.git
   ```
2. Navigate to the project directory:
   ```bash
   cd bot-travel
   ```
3. Update `application.properties` with your MongoDB URI:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster>.mongodb.net/<database>
   spring.data.mongodb.database=<database>
   ```
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Accessing APIs
- Navigate to Swagger UI at:
  ```
  http://localhost:8080/swagger-ui/index.html
  ```

---

## Data Models

### User
```json
{
  "userId": "string",
  "name": "string",
  "age": "integer",
  "bloodGroup": "string",
  "address": "string",
  "profilePictureUrl": "string",
  "hobbies": ["string"],
  "bio": "string",
  "interests": ["string"]
}
```

### Country
```json
{
  "id": "string",
  "name": "string",
  "code": "string",
  "capital": "string",
  "flagUrl": "string",
  "continent": "string",
  "population": "integer",
  "area": "float",
  "description": "string",
  "placesToVisit": [
    {
      "name": "string",
      "imageUrl": "string",
      "description": "string"
    }
  ],
  "visaInfoUrl": "string",
  "currency": {
    "code": "string",
    "rateToUSD": "float",
    "symbol": "string"
  },
  "details": {
    "popularDestinations": ["string"],
    "travelTips": "string"
  }
}
```

### UserCountry
```json
{
  "id": "string",
  "userId": "string",
  "countryCode": "string",
  "visited": "boolean",
  "notes": "string",
  "photoUrls": ["string"],
  "peopleMet": [
    {
      "name": "string",
      "nationality": "string",
      "contact": "string",
      "whatsapp": "string",
      "instagram": "string",
      "youtube": "string",
      "facebook": "string"
    }
  ]
}
```

---

## Contribution
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add feature-name"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Open a Pull Request.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

