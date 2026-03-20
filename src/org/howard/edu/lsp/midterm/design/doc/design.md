# Proposed Improved Design Using CRC Cards

## Overview
The redesigned system separates responsibilities into smaller, focused classes. Each class has a clear role and collaborates with others to process an order. 

---
## CRC Card
## Class: Order
**Responsibilities:**
- Store order data (customer name, email, item, price)
- Provide access to order details

**Collaborators:**
- OrderProcessor
- TaxCalculator
- DiscountStrategy

-------------------------------------------------------------------------------------------------------------------------------------------

## CRC Card
## Class: OrderProcessor
**Responsibilities:**
- Coordinate the overall order processing workflow
- Delegate tasks to appropriate components

**Collaborators:**
- Order
- TaxCalculator
- DiscountStrategy
- ReceiptPrinter
- OrderRepository
- NotificationService
- LoggerService

--------------------------------------------------------------------------------------------------------------------------------------------

## CRC Card
## Class: TaxCalculator
**Responsibilities:**
- Calculate tax based on order price

**Collaborators:**
- Order

---

## Class: DiscountStrategy
**Responsibilities:**
- Define a common interface for applying discounts

**Collaborators:**
- Order

---------------------------------------------------------------------------------------------------------------------------------------------

## CRC Card
## Class: HighValueDiscount (Concrete Strategy)
**Responsibilities:**
- Apply discount for orders above a certain threshold

**Collaborators:**
- DiscountStrategy
- Order

---

## Class: ReceiptPrinter
**Responsibilities:**
- Format and print order receipt

**Collaborators:**
- Order

-----------------------------------------------------------------------------------------------------------------------------------------------

## CRC Card
## Class: OrderRepository
**Responsibilities:**
- Save order details to storage (e.g., file or database)

**Collaborators:**
- Order

------------------------------------------------------------------------------------------------------------------------------------------------

## CRC Card
## Class: NotificationService
**Responsibilities:**
- Send confirmation notifications to customers

**Collaborators:**
- Order

--------------------------------------------------------------------------------------------------------------------------------------------------

## CRC Card
## Class: LoggerService
**Responsibilities:**
- Log order processing activities and timestamps

**Collaborators:**
- OrderProcessor

