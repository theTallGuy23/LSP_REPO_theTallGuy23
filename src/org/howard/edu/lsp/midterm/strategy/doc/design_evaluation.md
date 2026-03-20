# Design Evaluation

## Overview
The current implementation of the `PriceCalculator` class successfully computes final prices based on customer type. However, its design introduces several maintainability and extensibility issues that make it unsuitable for systems expected to evolve over time.

## Key Design Issues

### 1. Violation of the Open/Closed Principle
The class violates the Open/Closed Principle, which states that a class should be open for extension but closed for modification. In the current design, adding a new customer type (e.g., "STUDENT" or "BLACK_FRIDAY") requires modifying the existing `PriceCalculator` class. This increases the risk of introducing bugs into already tested code.

### 2. Use of Hardcoded Conditional Logic
The implementation relies on multiple `if` statements with hardcoded string values (e.g., "REGULAR", "MEMBER", etc.). This approach has several drawbacks:
- It is error-prone due to possible typos in string comparisons.
- It reduces readability as the number of conditions grows.
- It makes the logic harder to manage and debug.

### 3. Lack of Separation of Concerns
The `PriceCalculator` class is responsible for both:
- Determining the type of customer
- Applying the appropriate discount logic

This violates the principle of separation of concerns. Each discount rule should ideally be encapsulated in its own component, rather than being embedded within a single class.

### 4. Poor Scalability
As the number of customer types increases, the number of conditional statements will also grow. This leads to:
- Increased complexity
- Reduced readability
- Higher maintenance costs

Over time, this can result in a "God class" that handles too many responsibilities.

### 5. Difficulty in Testing and Reuse
Because all discount logic is embedded within a single method, it is difficult to:
- Test individual discount behaviors in isolation
- Reuse discount logic in other parts of the system

Encapsulating each discount into its own class would allow for more modular and testable code.

## Conclusion
While the current implementation is functional, it does not follow key object-oriented design principles. Refactoring the design using the Strategy Pattern would improve flexibility, maintainability, and scalability by encapsulating discount behaviors into separate, interchangeable components.
