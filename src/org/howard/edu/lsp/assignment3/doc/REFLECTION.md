# REFLECTION_A3.md

## Overview

This document compares my Assignment 2 implementation (a single, procedural main method) with my Assignment 3 implementation (a refactored, object-oriented design). Both versions perform the same ETL process on data/products.csv and produce data/transformed_products.csv with identical behavior and error handling. The differences are in how the code is structured, how responsibilities are divided, and how object-oriented concepts are applied.

---

## Assignment 2: Single Procedural Pipeline

In Assignment 2, all of the logic lived inside one class and one method:

- ETLPipeline contained a single public static void main(String[] args) that did everything.
- The main method:
  - Defined the input and output file paths as constants.
  - Checked if the input file existed and printed error messages if it did not.
  - Created BufferedReader and BufferedWriter objects.
  - Read the header, handled the empty input case, and wrote the output header.
  - Entered a while loop that:
    - Read each line.
    - Incremented rowsRead.
    - Skipped blank or malformed lines.
    - Parsed productId and price directly with Integer.parseInt and new BigDecimal.
    - Applied all transformation rules inline:
    - Once it was done, it finished the process.

  - Printed the summary (rows read, transformed, skipped, and output path).

Characteristics of this design:

- Procedural orientation:
  - The core logic was a long, step-by-step procedure in main.
  - Data and operations were not grouped into domain objects; they were primarily local variables.
- Tight coupling of concerns:
  - File I/O, CSV parsing, validation, business rules, and summary reporting were all interwoven.
- Limited reuse and testability:
  - To test the transformation logic, you had to run the entire program because there were no separate classes or methods representing the business rules.

The code was correct and straightforward, but it did not take advantage of object-oriented decomposition.

---

## Assignment 3: Object-Oriented ETL Design

In Assignment 3, I decomposed the logic into multiple classes under org.howard.edu.lsp.assignment3, each with a focused responsibility.

### ETLApplication (Entry Point)

- ETLApplication contains the new main method.
- Responsibilities:
  - Define the input and output paths.
  - Create an ETLRunner object and call runner.run().

This class serves as a minimal entry point and delegates the actual work to dedicated objects, instead of packing everything into main.

### ETLRunner (Orchestration and Summary)

- ETLRunner manages:
  - inputPath and outputPath.
  - Counters: rowsRead, rowsTransformed, rowsSkipped.
- Responsibilities:
  - Check if the input file exists and handle the “missing file” case with the same console output as Assignment 2.
  - Ensure the output directory exists.
  - Create a ProductFileProcessor and call its processFile() method.
  - Receive a Result object with counters and print the final summary.

This class encapsulates the overall pipeline flow and statistics, which were previously scattered as local variables in main.

### ProductFileProcessor (File-Level Processing)

- ProductFileProcessor takes a File (input) and a String (output path).
- Responsibilities:
  - Open BufferedReader and BufferedWriter.
  - Read the header, write the output header.
  - Handle the empty input case:
    - Write only the header to the output.
    - Print the same messages as Assignment 2.
  - Loop through each non-header line and delegate line-level work to ProductRowProcessor.
  - Aggregate results into a nested Result object with rowsRead, rowsTransformed, and rowsSkipped.
  This class isolates file handling and loop control from the transformation logic and from the high-level orchestration.

### ProductRowProcessor (Per-Line Parsing and Control)

- ProductRowProcessor provides a static processLine(...) method.
- Responsibilities:
  - Skip null, blank, or malformed lines (wrong number of fields).
  - Trim raw string fields for product ID, name, price, and category.

This class centralizes row-level validation and control flow and delegates the actual business transformation to its own class.

### ProductRecord (Raw Domain Object)

- ProductRecord represents a parsed input row:
  - productId (int)
  - name (String)
  - price (BigDecimal)
  - category (String)
- It exposes a static factory method fromStrings(...) that:
  - Attempts to parse the ID and price from strings.
  - Returns a ProductRecord on success, or null on parse failure.

This encapsulates the parsing of raw input data into a domain object, instead of keeping the parsing spread across the loop.

### TransformedProduct (Output Domain Object)

- TransformedProduct represents the final state of a product ready to be written out:
  - productId
  - name (uppercased)
  - price (final BigDecimal, already scaled to two decimals)
  - category (possibly "Premium Electronics")
  - priceRange (e.g., Low, Medium, High, Premium)

This encapsulates the post-transformation state of each product as an object rather than a collection of local variables.

### ProductTransformer (Business Rules)

- ProductTransformer encapsulates all the business logic that previously lived in the main loop:
  - Uppercase the product name.
  - Apply a 10% discount (0.90 multiplier) for "Electronics" (case-insensitive).
  - Round the final price to two decimal places (RoundingMode.HALF_UP), and so on.
  
This class isolates the core domain logic so it can be read, understood, and tested independently.

---

## Comparison: Procedural vs Object-Oriented

### Structure and Decomposition

- Assignment 2:
  - One main class (ETLPipeline) and one large main method.
  - All concerns (I/O, parsing, transformation, statistics, logging) were coded together.
- Assignment 3:
  - Multiple classes with single, clear responsibilities:
    - ETLApplication (entry point)
    - ETLRunner (orchestration)
    - ProductFileProcessor (file-level processing)
    - ProductRowProcessor (row-level control)
    - ProductRecord and TransformedProduct (data objects)
    - ProductTransformer (business rules)

This change moves from a single procedural script to a set of collaborating objects, which is a core idea of object-oriented design.

### Encapsulation and Data Modeling

- Assignment 2:
  - Data such as product ID, name, price, and category were just local variables or array elements inside the loop.
  
- Assignment 3:
  - ProductRecord and TransformedProduct encapsulate data for input and output, respectively.
  - Parsing is encapsulated in ProductRecord.fromStrings(...).
  - Business rules are encapsulated in ProductTransformer.transform(...).

### Reuse, Testability, and Maintainability

- Assignment 2:
  - To test or reuse the business logic, you had to go through the entire main method and the file I/O logic.
- Assignment 3:
  - Business rules live in ProductTransformer, which can be tested directly with artificial ProductRecord instances.
  - Parsing logic is isolated in ProductRecord, making it easier to test parsing errors and edge cases, and so on.

Overall, the new design makes it easier to reuse components and to modify one aspect (e.g., the transformation logic) without touching unrelated code (e.g., file paths or printing).

## Key Changes Made

- Split the monolithic ETLPipeline.main into several classes with focused responsibilities (ETLApplication, ETLRunner, ProductFileProcessor, ProductRowProcessor, ProductRecord, TransformedProduct, ProductTransformer).
- Introduced domain classes (ProductRecord, TransformedProduct) to represent input and output rows as objects instead of raw arrays and local variables.
- Encapsulated all business rules  inside a dedicated ProductTransformer class.
- Encapsulated file-level logic and the empty-file behavior in ProductFileProcessor, while keeping summary printing in ETLRunner.
---

Overall, the Assignment 3 design is a step toward cleaner object orientation and better separation of concerns, while still matching the functional requirements of Assignment 2.