package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
 * Handles reading the input file, writing the output file, and delegating line-level transformations.
 */
public class ProductFileProcessor {

    private final File inputFile;
    private final String outputPath;

    /* 
     * Constructs a processor for a given input file and output path.
     *
     * @param inputFile  input CSV file
     * @param outputPath output CSV file path
     */
    public ProductFileProcessor(File inputFile, String outputPath) {
        this.inputFile = inputFile;
        this.outputPath = outputPath;
    }

    /*
     *
     * Processes the entire file: reads header, handles empty file, processes each row,
     * and returns statistics.
     *
     * @return result statistics for the processing
     */
    public Result processFile() {
        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputPath));

            String header = reader.readLine();
            if (header == null) {
                writeHeader(writer);
                printEmptyInputMessage();
                return new Result(0, 0, 0);
            }

            writeHeader(writer);

            ProductTransformer transformer = new ProductTransformer();

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                ProductRowProcessor.RowOutcome outcome =
                        ProductRowProcessor.processLine(line, transformer, writer);

                switch (outcome) {
                    case TRANSFORMED:
                        rowsTransformed++;
                        break;
                    case SKIPPED:
                        rowsSkipped++;
                        break;
                    default:
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: I/O problem occurred - " + e.getMessage());
        } finally {
            closeQuietly(reader, writer);
        }

        return new Result(rowsRead, rowsTransformed, rowsSkipped);
    }

    private void writeHeader(BufferedWriter writer) throws IOException {
        writer.write("ProductID,Name,Price,Category,PriceRange");
        writer.newLine();
    }

    private void printEmptyInputMessage() {
        System.out.println("Empty input file detected. Created output file with header only.");
    }
    
    private void closeQuietly(BufferedReader reader, BufferedWriter writer) {
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
}