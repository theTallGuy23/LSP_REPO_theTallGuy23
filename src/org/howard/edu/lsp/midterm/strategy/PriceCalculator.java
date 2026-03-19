package org.howard.edu.lsp.midterm.strategy;

/**
 * PriceCalculator uses a DiscountStrategy to calculate final prices.
 */
public class PriceCalculator {

    private DiscountStrategy discountStrategy;

    /**
     * Sets the discount strategy.
     *
     * @param discountStrategy the strategy to apply
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the selected discount strategy.
     *
     * @param price the original price
     * @return the final price after discount
     */
    public double calculatePrice(double price) {
        if (discountStrategy == null) {
            throw new IllegalStateException("Discount strategy not set.");
        }
        return discountStrategy.applyDiscount(price);
    }
}
