package org.howard.edu.lsp.assignment3;

    /*
     * Aggregated result statistics for processing a file.
     */
public class Result {
    private final int rowsRead;
    private final int rowsTransformed;
    private final int rowsSkipped;

    /* 
     * Constructs a Result instance.
     *
     * @param rowsRead        total non-header rows encountered
     * @param rowsTransformed total rows successfully transformed and written
     * @param rowsSkipped     total rows skipped due to errors or invalid data
     */
    public Result(int rowsRead, int rowsTransformed, int rowsSkipped) {
        this.rowsRead = rowsRead;
        this.rowsTransformed = rowsTransformed;
        this.rowsSkipped = rowsSkipped;
    }

    public int getRowsRead() {
        return rowsRead;
    }

    public int getRowsTransformed() {
        return rowsTransformed;
    }

    public int getRowsSkipped() {
        return rowsSkipped;
    }
}