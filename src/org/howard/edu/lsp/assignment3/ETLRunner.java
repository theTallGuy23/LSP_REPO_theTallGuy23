package org.howard.edu.lsp.assignment3;

import java.io.File;

/* 
 * Coordinates the ETL process and tracks row statistics.
 */
public class ETLRunner {

    private final String inputPath;
    private final String outputPath;

    private int rowsRead;         // non-header rows encountered (including bad ones)
    private int rowsTransformed;  // rows written to output
    private int rowsSkipped;      // bad/invalid rows

    /* 
     * Constructs a new ETLRunner with input and output paths.
     *
     * @param inputPath  path to the input CSV file
     * @param outputPath path to the output CSV file
     */
    public ETLRunner(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    /**
     * Executes the ETL process and prints the summary, matching Assignment 2 behavior.
     */
    public void run() {
        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            handleMissingInput();
            return;
        }
    

        ensureOutputDirectory();

        ProductFileProcessor processor = new ProductFileProcessor(inputFile, outputPath);
        Result result = processor.processFile();

        this.rowsRead = result.getRowsRead();
        this.rowsTransformed = result.getRowsTransformed();
        this.rowsSkipped = result.getRowsSkipped();

        printSummary();
    }

    private void handleMissingInput() {
        System.out.println("Error: Input file not found at path: " + inputPath);
        System.out.println("Rows read: 0");
        System.out.println("Rows transformed: 0");
        System.out.println("Rows skipped: 0");
        System.out.println("No output file created because input file is missing.");
    }

    private void ensureOutputDirectory() {
        File outputFile = new File(outputPath);
        File outputDir = outputFile.getParentFile();
        if (outputDir != null && !outputDir.exists()) {
            outputDir.mkdirs();
        }
    }

    private void printSummary() {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file path: " + outputPath);
    }
}