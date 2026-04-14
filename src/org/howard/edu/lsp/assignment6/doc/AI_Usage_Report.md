# AI_Usage_Report.md

## AI Tool Used  
ChatGPT (OpenAI) and the internet

---

## Summary of Usage  
I used ChatGPT as a learning assistant throughout this assignment. I asked it a very brief example about what JUnit 5 testing looks like, and then I proceeded to implement the tests myself.

---

## Conversation Breakdown  

### 1. Understanding the New Assignment

I first copied and pasted IntegerSet.java from assignment 5 into assignment 6. I created a new file called IntegerSetTest.java as per the assignment description.

---

### 2. Understanding What JUnit Tests Are For

I then explained that I did not know how JUnit tests work or how to run them, and asked ChatGPT to show me examples of simple JUnit tests. I then understood the necessary import statements I needed to include, packages like ("org.junit.jupiter.api.Test"), ("static org.junit.jupiter.api.Assertions.assertTrue) and so on. I also understood the importance of including the @Test directive to signal to Java that the function below is a test and that it must be run automatically. With these three basic but important details, I went on to build the skeleton of the code. 

---

### 3. Method-by-Method Test Coverage

I then wrote tests covering:
- clear() normal and edge cases 
- length() normal and edge cases
- equals() with same elements in different order and mismatch
- contains() for present and absent values
- largest() and smallest() for normal, single-element, and empty-set exception cases
- add() with duplicate-value edge case
- remove() when the value exists and when it does not exist
- union() with a normal case and with an empty set
- intersect() with common elements and with no overlap
- diff() with a normal case and identical sets
- complement() with a normal case and disjoint sets
- isEmpty() for empty and non-empty sets
- toString() for normal and empty sets

These were the test cases I was supposed to cover as per the assignment description, and I used a online references to understand how some functions like assertEquals(), assertTrue() work, the parameters they take, and so on. Once I knew how to use these functions, writing the tests was easy. In fact, you almost copy paste the implementation of the functions in IntegerSet.java because that is what you are testing for. I did modify some parts of some functions for edge cases but for the most part, it was just a redo of IntegerSet.java but in a test environment, therefore instead of returning any value from the functions, I instead used the assertEquals() or assertTrue() or assertFalse() based on the condition I am checking for, as I see fit.

---

### 4. Double-Checking Correctness

I then sent my code to chatGPT and then asked it to double check the code and verify that each function behaved as intended. 
This helped me feel more confident that both the code and the tests aligned with the assignment description, and I made sure all tests passed.

---

## External Resources  
I have used google search for how to use some functions in JUnit 5, like the assertEquals, assertTrue and functions of these sorts.
