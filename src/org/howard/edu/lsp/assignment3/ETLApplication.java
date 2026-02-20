package org.howard.edu.lsp.assignment3;

/*
 *
 * Entry point for Assignment 3 ETL application.
 * Orchestrates reading, transforming, and writing product data.
 */
public class ETLApplication {

    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        ETLRunner runner = new ETLRunner(inputPath, outputPath);
        runner.run();
    }
}