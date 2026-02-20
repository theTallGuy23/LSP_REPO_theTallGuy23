package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.IOException;

/*
 * Processes individual CSV lines and delegates business logic to ProductTransformer.
 */
public class ProductRowProcessor {

    /* 
     * Outcome for a processed row.
     */
    public enum RowOutcome {
        TRANSFORMED,
        SKIPPED,
        NONE
    }

    private ProductRowProcessor() {
        // Utility class, not intended to be instantiated.
    }

    /*
     *
     * Processes a single line from the input file.
     *
     * @param line         raw CSV line (excluding header)
     * @param transformer  transformer that applies business rules
     * @param writer       writer for the output CSV
     * @return the outcome of processing this row
     */
    public static RowOutcome processLine(
            String line,
            ProductTransformer transformer,
            BufferedWriter writer) {

        if (line == null) {
            return RowOutcome.NONE;
        }

        if (line.trim().isEmpty()) {
            return RowOutcome.SKIPPED;
        }

        String[] parts = line.split(",", -1);
        if (parts.length != 4) {
            return RowOutcome.SKIPPED;
        }

        String productIdStr = parts[0].trim();
        String name = parts[1].trim();
        String priceStr = parts[2].trim();
        String category = parts[3].trim();

        ProductRecord record = ProductRecord.fromStrings(productIdStr, name, priceStr, category);
        if (record == null) {
            return RowOutcome.SKIPPED;
        }

        TransformedProduct transformed = transformer.transform(record);
        writeTransformed(transformed, writer);

        return RowOutcome.TRANSFORMED;
    }

    private static void writeTransformed(TransformedProduct product, BufferedWriter writer) {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getProductId());
        sb.append(",");
        sb.append(product.getName());
        sb.append(",");
        sb.append(product.getPriceAsString());
        sb.append(",");
        sb.append(product.getCategory());
        sb.append(",");
        sb.append(product.getPriceRange());

        try {
            writer.write(sb.toString());
            writer.newLine();
        } catch (IOException e) {
            // Match Assignment 2 behavior: print a generic I/O error.
            System.out.println("Error: I/O problem occurred - " + e.getMessage());
        }
    }
}