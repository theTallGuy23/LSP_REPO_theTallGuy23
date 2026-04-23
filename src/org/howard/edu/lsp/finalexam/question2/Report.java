package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class for all reports.
 * Uses the Template Method pattern to define a fixed report-generation workflow.
 */
public abstract class Report {

    /**
     * Template method that defines the fixed workflow for generating a report.
     */
    public final void generateReport() {
        loadData();

        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();

        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();

        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }

    /**
     * Loads the data needed for the report.
     */
    protected abstract void loadData();

    /**
     * Formats the report header.
     *
     * @return the formatted header
     */
    protected abstract String formatHeader();

    /**
     * Formats the report body.
     *
     * @return the formatted body
     */
    protected abstract String formatBody();

    /**
     * Formats the report footer.
     *
     * @return the formatted footer
     */
    protected abstract String formatFooter();
}
