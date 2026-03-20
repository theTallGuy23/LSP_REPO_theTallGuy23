# Design Evaluation – OrderProcessor Class

## Overview
At first glance, the `OrderProcessor` class appears to handle order processing correctly. However, after examining it more closely, it becomes clear that the class takes on too many responsibilities and violates several object-oriented design principles. These issues make the system harder to maintain and extend over time.

## Key Design Issues

### 1. Too Many Responsibilities (Single Responsibility Principle) (SRP)
The `OrderProcessor` class is responsible for multiple tasks, including:
- Calculating tax
- Applying discounts
- Printing receipts
- Saving data to a file
- Sending email notifications
- Logging activity

These responsibilities are unrelated and should not be handled by a single class. If any one of these behaviors changes (for example, changing how emails are sent), the entire class must be modified. This is a typical error that needs to be fixed.

---

### 2. Poor Encapsulation
The class exposes its data through public fields such as `customerName`, `email`, `item`, and `price`. This allows external code to modify these values freely without any validation. This breaks encapsulation and makes it difficult to control the integrity of the data. 

---

### 3. Tight Coupling to Implementation Details
The class directly uses:
- `FileWriter` for saving orders
- `System.out.println` for output and logging

This tightly couples the class to specific technologies. If the system later needs to use a database instead of a file, or a logging framework instead of console output, the class must be rewritten.

---

### 4. Lack of Modularity
All logic is placed inside a single method, `processOrder()`. There are no smaller components or helper classes to separate different behaviors. This makes the code harder to read, harder to test, and harder to reuse.

It would be much easier to break the system into smaller classes (e.g., TaxCalculator, NotificationService) for better modularity.

---

### 5. Hardcoded Logic and Values
The class includes hardcoded values such as:
- Tax rate (0.07)
- Discount condition (`price > 500`)
- Discount rate (10%)
- File name ("orders.txt")

These values are fixed in the code, making it difficult to change business rules without modifying the class.

---

### 6. Mixed Levels of Abstraction
The `processOrder()` method mixes high-level operations (processing an order) with low-level details (writing to a file, printing output).

This makes the method harder to understand because it does not operate at a consistent level of abstraction.

---

### 7. Limited Extensibility
The design is not flexible. For example, if we wanted to add a new discount rule, it would require us to modify existing code. Same goes with changing how notifications are sent. This violates the idea that systems should be easy to extend without changing existing functionality.

---

## Connection to Object-Oriented Design Heuristics

The issues observed in this class align with several object-oriented design heuristics described by Arthur Riel. In particular:

- Classes should have a single, well-defined responsibility
- Data should be hidden within classes
- Classes should be loosely coupled
- Responsibilities should be distributed across multiple collaborating classes

The `OrderProcessor` class violates these guidelines, which leads to poor maintainability and reduced flexibility.
