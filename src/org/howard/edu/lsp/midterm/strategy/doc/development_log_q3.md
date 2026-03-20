# Development Log – Question 3

## Overview
This document outlines the external resources and tools used while completing Question 3, including the design evaluation, refactoring using the Strategy Pattern, and implementation of the driver program.

---

## Resource 1: AI Assistance (ChatGPT)

### What I Asked
I used an AI assistant (ChatGPT) to guide me through the refactoring process. My interaction was iterative and step-based. Below is a summary of how I used it:

1. **Understanding the Problem**
   - I first asked whether the provided `PriceCalculator` code was correctly understood and what design issues it might have.
   - This helped confirm my understanding of the current implementation and identify key problems such as reliance on conditional logic.

2. **Design Evaluation (Part 1)**
   - I asked for help writing a proper design evaluation in Markdown format.
   - The AI helped structure the response clearly and ensured that important object-oriented design principles (such as the Open/Closed Principle and Separation of Concerns) were properly explained.

3. **Strategy Pattern Refactoring (Part 2)**
   - I asked how to refactor the code using the Strategy Pattern.
   - The AI guided me through:
     - Creating a `DiscountStrategy` interface
     - Implementing concrete strategy classes (Regular, Member, VIP, Holiday)
     - Refactoring the `PriceCalculator` to use a strategy object instead of conditional logic
   - This step-by-step guidance helped me understand how to apply the Strategy Pattern in practice.

4. **Driver Class Implementation (Part 3)**
   - I asked for help creating a driver program that demonstrates all required cases.
   - The AI showed how to properly use the strategy classes and ensured that the output matched the exact format required by the assignment.

### How It Helped
The AI assistance was primarily used as a learning and guidance tool. It helped me reinforce my understanding of design patterns, and all code was reviewed and understood before being used.

---



## Resource 2: Java Documentation

### What I Used
- Basic Java syntax and structure for:
  - Interfaces
  - Class design
  - Method overriding

---

## Conclusion
I used AI and java docmentation to write the code successfully. I used the java documentation to understand method overriding and AI to assist in writing the actual code.
