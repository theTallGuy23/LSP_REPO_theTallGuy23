package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to demonstrate the Strategy Pattern implementation.
 */
public class Driver {

    /**
     * Main method to test different discount strategies.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        double price = 100.0;

        PriceCalculator calculator = new PriceCalculator();

        // REGULAR customer
        calculator.setDiscountStrategy(
                DiscountStrategyFactory.getStrategy("REGULAR"));
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        // MEMBER customer
        calculator.setDiscountStrategy(
                DiscountStrategyFactory.getStrategy("MEMBER"));
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        // VIP customer
        calculator.setDiscountStrategy(
                DiscountStrategyFactory.getStrategy("VIP"));
        System.out.println("VIP: " + calculator.calculatePrice(price));

        // HOLIDAY customer
        calculator.setDiscountStrategy(
                DiscountStrategyFactory.getStrategy("HOLIDAY"));
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}
