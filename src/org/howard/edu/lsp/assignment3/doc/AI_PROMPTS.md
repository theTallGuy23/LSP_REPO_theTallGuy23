# AI_PROMPTS_A3.md

## Prompt 1 – Understanding the Assignment and Rubric

User Prompt

> I have a Java ETL pipeline I built for Assignment 2. For Assignment 3, I need to redesign it to be more object-oriented while keeping the exact same behavior: same inputs, outputs, transformations, error handling, and file paths.  
>  
> Here is the Assignment 3 description and rubric: Package must be org.howard.edu.lsp.assignment3, one public class per file, Javadocs on classes and public methods, etc.. Can you can help me refactor my code accordingly?

AI Response (Excerpt)

> The requirements are clear. Once you send your Assignment 2 code, I can help you refactor it into multiple object-oriented classes under org.howard.edu.lsp.assignment3, preserving all input/output behavior.

> // I sent the code to the AI Agent here. It will take up space to copy paste the entire procedural code in this markdown, so I decided not to do it.

> I need this behavior to stay exactly the same. Can you help me redesign this in a more object-oriented way?

AI Response (Excerpt)

> Yes. I will preserve the exact behavior and refactor this into multiple classes, with one public class per file and Javadocs for classes and public methods.

---

## Prompt 3 – Proposing an OO Structure

User Prompt

> Before you write any code, propose an object-oriented design based on this ETL pipeline. I still need the same input/output files and console messages, same transformation rules and error handling, and finally, one public class per file. Suggest the main classes you would create and what each class would be responsible for.

AI Response (Excerpt)

> I recommend the following classes:
> - ETLApplication – entry-point with main, delegates to a runner.  
> - ETLRunner – orchestrates the process, tracks row statistics, and prints the final summary.  
> - ProductFileProcessor – handles reading/writing files and looping over rows.  
> - ProductRowProcessor – parses a line, validates fields, and calls the transformer.  
> - ProductRecord – represents a parsed input row (ID, name, price, category).  
> - TransformedProduct – represents a fully transformed row ready to be written.  
> - ProductTransformer – encapsulates all business rules (uppercasing, discounts, categories, and price ranges).  

## Prompt 4 – Generate the Core Classes and Main

User Prompt

> Now, please implement the new object-oriented version in Java, with:
> - ETLApplication containing the main method.  
> - ETLRunner coordinating the process and printing the summary.  
> - ProductFileProcessor managing the file I/O and using a nested Result class to hold row counts.  
>  
> Make sure:
> - The input path is still "data/products.csv".  
> - The output path is still "data/transformed_products.csv".  
 
## Prompt 5 – Implement Row and Domain Classes

User Prompt

> Great start.  
>  
> Next, write the remaining classes you mentioned:
> - ProductRowProcessor for processing each CSV line.  
> - ProductRecord for the raw input representation.  
> - TransformedProduct for the transformed output representation.  
> - ProductTransformer to encapsulate all business rules.  
>  
> Requirements:
> - Keep the transformation logic identical to my original code (same discount rule, rounding, category promotion, and price ranges).  
> - Ensure TransformedProduct can output the price with toPlainString() so it matches my previous CSV output.  

AI Response (Excerpt)

> Sure! Here are those classes:

> The AI Agent produced the code for me here too. No need to copy paste it.

## Prompt 6 – Verify Behavioral Equivalence

User Prompt

> I need to be sure the new object-oriented version behaves exactly like the original ETLPipeline version.  
>  
> Can you walk me through which parts of the new code correspond to the missing-file behavior, the empty-file behavior, the per-row parsing and skipping rules, and the transformation steps and price range logic?
> I want to confirm nothing changed from the user’s point of view.

AI Response (Excerpt)

> - Missing-file behavior: handled in ETLRunner.run() when the input file does not exist, printing the same four lines you had in Assignment 2.  
> - Empty-file behavior: handled inside ProductFileProcessor.processFile() when the header is null, writing only the header and printing the same summary.  
> - Per-row parsing and skipping: handled by ProductRowProcessor.processLine(...), which mirrors your checks for blank lines, wrong column counts, and NumberFormatException.  
> - Transformation and price range: handled in ProductTransformer.transform(...) using the same discount factor, rounding mode, category promotion, and thresholds (10, 100, 500).  







