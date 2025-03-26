Insurance Purchase API
======================

Overview
--------

This project provides a RESTful API for managing insurance purchases, built using **Spring Boot**. The API allows users to:

*   Retrieve a list of insurance products tailored to their profile (based on age, gender, and income).
    
*   Purchase an insurance product with a simulated payment process.
    
*   Download a policy document in PDF format after a successful purchase.
    

Key features include user authentication, error handling, and dynamic PDF generation, making it a robust solution for insurance-related operations.

API Endpoints

### 1\. List Available Insurances

*   **Endpoint**: GET /api/insurances?userId={userId}
    
*   **Description**: Returns a list of insurance products customized to the user’s profile.
    
*   **Parameters**:
    
    *   userId (required): The ID of the user.
        
*   **Response**: A JSON array of insurance objects.
    

**Sample Request**:

curl -u user:password http://localhost:8080/api/insurances?userId=1

**Sample Response**:\[

{

"id": 1,

"name": "Health Plus",

"premium": 500.0,

"description": "Comprehensive health coverage",

"minAge": 18,

"maxAge": 60,

"targetGender": "ANY",

"minIncome": 30000.0

}

\]

### 2\. Purchase Insurance

*   **Endpoint**: POST /api/insurances/{insuranceId}/purchase?userId={userId}&amount={amount}
    
*   **Description**: Allows a user to purchase a specific insurance product.
    
*   **Parameters**:
    
    *   insuranceId (path parameter): The ID of the insurance product to purchase.
        
    *   userId (query parameter): The ID of the user making the purchase.
        
    *   amount (query parameter): The payment amount for the insurance.
        
*   **Response**: A JSON object representing the purchase receipt.
    

**Sample Request**:

curl -u user:password -X POST "http://localhost:8080/api/insurances/1/purchase?userId=1&amount=500.0"

**Sample Response**:{

"id": 1,

"userId": 1,

"insuranceId": 1,

"transactionId": "a1b2c3d4-e5f6-7890-abcd-1234567890ab",

"purchaseDate": "2024-10-19T12:34:56"

}

### 3\. Download Policy Document

*   **Endpoint**: GET /api/insurances/policy/{purchaseId}
    
*   **Description**: Downloads a PDF policy document for a specific purchase.
    
*   **Parameters**:
    
    *   purchaseId (path parameter): The ID of the purchase.
        
*   **Response**: A PDF file.
    

**Sample Request**:

curl -u user:password http://localhost:8080/api/insurances/policy/1 --output policy.pdf

Details of Solution
-------------------

The Insurance Purchase API is designed to provide a robust and user-friendly experience with the following features:

*   **Personalized Insurance Listings**: Insurance products are filtered based on the user’s age, gender, and income, ensuring tailored recommendations.
    
*   **Simulated Payment Processing**: A mock payment gateway generates a unique transaction ID for each purchase, simulating real-world payment systems.
    
*   **Dynamic PDF Generation**: Policy documents are created dynamically using the iText library, including purchase-specific details.
    
*   **User Management**: User data is stored in memory (for simplicity) and used to customize insurance offerings.
    
*   **Security**: Basic authentication is implemented with Spring Security to secure API endpoints.
    
*   **Error Handling**: A global exception handler provides meaningful error messages and appropriate HTTP status codes.
    

Key Components

*   **Models**:
    
    *   Insurance: Represents an insurance product.
        
    *   User: Stores user profile data.
        
    *   Purchase: Tracks purchase details.
        
*   **Services**:
    
    *   UserService: Manages user data.
        
    *   InsuranceService: Handles insurance listings and purchases.
        
    *   PaymentService: Simulates payment processing.
        
    *   PdfService: Generates policy PDFs.
        
*   **Controller**:
    
    *   InsuranceController: Defines the API endpoints.
        
*   **Security**:
    
    *   SecurityConfig: Configures basic authentication.
        
*   **Exception Handling**:
    
    *   GlobalExceptionHandler: Manages errors across the application.
        

Deployment Notes

To deploy the API on a public server, follow these steps:

1.  **Build the JAR**:
    
    *   Run the following command in the project root directory:
        
    *   mvn clean package
        
2.  This generates an executable JAR file (e.g., insurance-api-0.0.1-SNAPSHOT.jar).
    
3.  **Server Setup**:
    
    *   Select a cloud provider (e.g., AWS, Heroku, DigitalOcean).
        
    *   Upload the JAR file to the server using a tool like SCP or an FTP client.
        
4.  **Run the Application**:
    
    *   Execute the JAR file on the server:
        

java -jar insurance-api-0.0.1-SNAPSHOT.jar

**Configure Domain/Port**:

*   Ensure the server allows inbound traffic on port 8080 (default).
    
*   Optionally, configure a reverse proxy (e.g., Nginx) to map a domain name to the application.
