package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
    
public class ETLPipeline {
    
    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";
    
    public static void main(String[] args) {
        int rowsRead = 0;        // non-header rows encountered (including bad ones)
        int rowsTransformed = 0; // rows written to output
        int rowsSkipped = 0;     // bad/invalid rows

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            File inputFile = new File(INPUT_PATH);
            if (!inputFile.exists()) {
                System.out.println("Error: Input file not found at path: " + INPUT_PATH);
                System.out.println("Rows read: 0");
                System.out.println("Rows transformed: 0");
                System.out.println("Rows skipped: 0");
                System.out.println("No output file created because input file is missing.");
                return;
            }

            // Ensure output directory exists
            File outputFile = new File(OUTPUT_PATH);
            File outputDir = outputFile.getParentFile();
            if (outputDir != null && !outputDir.exists()) {
                outputDir.mkdirs();
            }

            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile));

            // Read header
            String header = reader.readLine();
            if (header == null) {
                writer.write("ProductID,Name,Price,Category,PriceRange");
                writer.newLine();
                
                System.out.println("Empty input file detected. Created output file with header only.");
                System.out.println("Rows read: 0");
                System.out.println("Rows transformed: 0");
                System.out.println("Rows skipped: 0");
                System.out.println("Output file path: " + OUTPUT_PATH);
                return;
            }
            
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();
            String line;
            while ((line = reader.readLine()) != null)  {
                // Count every non-header line encountered
                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",", -1); // keep empty fields
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                // Trim whitespace around each field
                String productIdStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                // Parse ProductID and Price; skip if invalid
                int productId;
                BigDecimal originalPrice;
                try {
                    productId = Integer.parseInt(productIdStr);
                    originalPrice = new BigDecimal(priceStr);
                } catch (NumberFormatException e) { // if there is a problem parsing either product ID or price, skip the row 
                    rowsSkipped++;
                    continue;
                }

                // 1. Convert all product names to UPPERCASE
                String transformedName = name.toUpperCase();

                // 2. If the category is "Electronics", apply a 10% discount to the price.
                String originalCategory = category;
                BigDecimal finalPrice = originalPrice;
                if ("Electronics".equalsIgnoreCase(originalCategory)) {
                    // finalPrice = originalPrice * 0.9
                    BigDecimal discountFactor = new BigDecimal("0.90");
                    finalPrice = finalPrice.multiply(discountFactor);
            }

            // Round final price to exactly two decimal places (round-half-up)
            finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);

            // 3. If final rounded price > 500.00 AND original category was "Electronics",
            //    change category to "Premium Electronics".
            
            String finalCategory = originalCategory.trim();
            BigDecimal lowThreshold = new BigDecimal("10.00");
            BigDecimal midThreshold = new BigDecimal("100.00");
            BigDecimal highThreshold = new BigDecimal("500.00");
            if ("Electronics".equalsIgnoreCase(originalCategory)
                    && finalPrice.compareTo(highThreshold) > 0) {
                finalCategory = "Premium Electronics";
            }

            // 4. Add PriceRange based on final rounded price
            String priceRange;
            
            if (finalPrice.compareTo(new BigDecimal("10.00")) <= 0) {
                priceRange = "Low";
            } else if (finalPrice.compareTo(lowThreshold) > 0
                    && finalPrice.compareTo(midThreshold) <= 0) {
                priceRange = "Medium";
            } else if (finalPrice.compareTo(midThreshold) > 0
                    && finalPrice.compareTo(highThreshold) <= 0) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }

            // Write output row: ProductID, Name, Price, Category, PriceRange
            // Price must always be written with exactly two decimal places
            StringBuilder sb = new StringBuilder(); // Use StringBuilder for efficient concatenation
            sb.append(productId);
            sb.append(",");
            sb.append(transformedName);
            sb.append(",");
            sb.append(finalPrice.toPlainString());
            sb.append(",");
            sb.append(finalCategory);
            sb.append(",");
            sb.append(priceRange);

            writer.write(sb.toString());
            writer.newLine();
            rowsTransformed++; // A successful transformation.
        }

    } catch (IOException e) {
        System.out.println("Error: I/O problem occurred - " + e.getMessage());
    } finally {
        // Close resources safely
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                // ignore
            }
        }
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
    
    // Print summary
    System.out.println("Rows read: " + rowsRead);
    System.out.println("Rows transformed: " + rowsTransformed);
    System.out.println("Rows skipped: " + rowsSkipped);
    System.out.println("Output file path: " + OUTPUT_PATH);
}
}

