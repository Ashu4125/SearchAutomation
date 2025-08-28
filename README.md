# ✈️ Flight Search Automation Testing Project  

## 📌 Project Overview  
This project automates the **Flight Search functionality** of the **[Goibibo](https://www.goibibo.com)** travel booking website using **Java, Selenium WebDriver, TestNG, and Maven**.  
The goal is to validate **One Way and Round Trip flight searches**, including:  
- Airport selection  
- Discount options (**Armed Forces, Student, Senior Citizen, Doctors**)  
- Traveler details  
- Date selection  

The framework follows the **Page Object Model (POM)** design pattern for **maintainability and scalability**.  

---

## ✅ Test Flow  
The automation script simulates the following user journey:  

### **1. Select Trip Type**  
- One Way  
- Round Trip  

### **2. Enter Airports**  
- From Airport (e.g., **Delhi - DEL**)  
- To Airport (e.g., **Mumbai - BOM**)  

### **3. Apply Discounts**  
- Armed Forces  
- Student  
- Senior Citizen  
- Doctors  

### **4. Select Travellers & Class**  
- Adults (e.g., **1, 2, or more**)  
- Children (e.g., **0 or more**)  
- Infants (e.g., **0 or more**)  
- Travel Class: **Economy, Business, or Premium Economy**  

### **5. Select Dates**  
- Departure Date  
- Return Date (for Round Trip)  

### **6. Search & Validate**  
- ✅ Search results page loads successfully  
- ✅ Applied filters (e.g., discounts, passenger count) are reflected correctly  
- ✅ At least one flight option is available with valid details (**airline name, price, etc.**)  

---

## ✅ Features  
✔ Validates **One Way** and **Round Trip** flight searches  
✔ Verifies **discount options** (Armed Forces, Student, Senior Citizen, Doctors)  
✔ Supports **dynamic traveler selection** (Adults, Children, Infants) and travel class  
✔ Automates **date picker** for departure and return dates  
✔ Validates **dynamic search results** based on user inputs  
✔ Captures **screenshots on test failure** for debugging  
✔ Implements **logging using Log4j** for detailed execution logs  
✔ Generates **HTML reports using TestNG and Extent Reports**  
✔ Handles **invalid inputs** (e.g., unavailable airports, past dates) with proper validation  

---

## ✅ Tools & Technologies  
- **Java**: JDK 8+  
- **Selenium WebDriver**: Browser automation  
- **TestNG**: Test execution and reporting  
- **Maven**: Dependency management and build automation  
- **Log4j**: Logging execution details  
- **Extent Reports**: Detailed HTML test reports  
- **Git & GitHub**: Version control  
- **WebDriverManager**: Automatic browser driver management  
- **IDE**: IntelliJ IDEA (recommended) or Eclipse  

