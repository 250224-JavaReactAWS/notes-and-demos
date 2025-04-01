# RevStay Application Project

- Due Date: Friday, April 11th, 2025
- All code for this project should be pushed to your personal repository in the Github Organization BEFORE presentations begin

## Project Description
The **RevStay Application** is a full-stack web application that enables users to search for hotels, make reservations, and manage their bookings. It also provides hotel owners with tools to manage their properties and bookings. 

The project will be implemented using:
- **Spring Boot** (Backend API development)
- **Spring Web** (RESTful APIs)
- **Spring Data JPA** (Database interactions with PostgreSQL)
- **React with TypeScript** (Frontend UI)
- **PostgreSQL** (Relational database for storing data)
    - Should be hosted on AWS RDS
- **Logback** (Logging Framework)
- **JUnit and Mockito** (Testing and Mocking Frameworks)

---

## **User Stories**

### **User Account (Traveler)**
1. **As a user, I want to register on the platform so that I can make bookings. (*MVP*)**
2. **As a user, I want to log in using my email/username and password so that I can access my account. (*MVP*)**
3. **As a user, I want to search and view hotel details including images, location, price, amenities, and user reviews. (*MVP*)**
4. **As a user, I want to filter hotels based on location and price range so that I can find the best options.**
5. **As a user, I want to make hotel reservations by selecting check-in and check-out dates, room type, and number of guests. (*MVP*)**
6. **As a user, I want to view and manage my bookings, including modifying or canceling reservations. (*MVP*)**
7. **As a user, I want to receive email or push notifications for booking confirmations and updates.**
8. **As a user, I want to provide a review of the hotel so that other users can make informed decisions.**
9. **As a user, I want to save hotels as favorites for future reference.**
10. **As a user, I want to generate invoices for completed bookings.**
11. **As a user, I want to make payments securely through integrated payment gateways.**

### **Hotel Owner Account**
1. **As a hotel owner, I want to register as a seller with email, password, and business details so that I can list my properties. (*MVP*)**
2. **As a hotel owner, I want to log in using my email and password so that I can access my dashboard. (*MVP*)**
3. **As a hotel owner, I want to manage hotel listings and details, including images, descriptions, pricing, and availability. (*MVP*)**
4. **As a hotel owner, I want to receive notifications for new bookings and reservation updates.**
5. **As a hotel owner, I want to view and manage reservations, including accepting or rejecting bookings. (*MVP*)**
6. **As a hotel owner, I want to respond to user reviews and feedback.**
7. **As a hotel owner, I want to manage room inventory and availability. (*MVP*)**
8. **As a hotel owner, I want to monitor booking statistics and analytics to track performance.**


### **Developer User Stories**
1. **As a developer, I want to log events within the application for later processing or in the event of an error.**
2. **As a developer, I want to create unit tests that cover the Service layer of the application, providing at least 80% coverage for methods in those classes**
---

## **Additional Stretch Goals (Optional)**

### **Advanced User Features**
1. **As a user, I want to reset my password if I forget it.**
2. **As a user, I want to receive personalized hotel recommendations based on my search history.**

### **Enhanced Booking & Payment Features**
3. **As a user, I want to apply discount codes or promotions to my bookings.**
4. **As a user, I want to split payments across multiple payment methods.**
5. **As a user, I want to receive an automated refund if I cancel my reservation within the allowed period.**

### **Admin & Analytics**
6. **As an admin, I want to view platform-wide analytics, including total bookings, top-rated hotels, and revenue.**
7. **As an admin, I want to manage user accounts, including suspending fraudulent accounts.**

---


