# Item Management REST API (Spring Boot)

This is a simple Spring Boot RESTful API for managing a collection of items.
The application demonstrates basic CRUD-style operations using an in-memory data store.

---

## Tech Stack
- Java 21
- Spring Boot
- Maven
- Postman (API testing)

---

##  Features
- Add a new item
- Get all items
- Get an item by ID
- Input validation
- Proper HTTP status codes

---

##  How to Run the Application

1. Download or clone the project
2. Open the project in VS Code / IntelliJ
3. Run `ItemapiApplication.java`
4. Application starts on:
    http://localhost:8080


## API Endpoints

###  Add Item
**POST** `/api/items`

Request Body:
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop"
}```


Response:
    - 201 CREATED

---

### Get All Items
**GET** `/api/items`
Response:
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "Gaming Laptop"
  }
]
```

---

### 🔍 Get Item by ID
**GET** `/api/items/{id}`

Example:

Response (Success):
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop"
}

Response (Failure):

404 NOT FOUND – Item not found

