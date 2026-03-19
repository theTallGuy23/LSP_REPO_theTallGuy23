package org.howard.edu.lsp.midterm.strategy;

/**
 * No discount applied for regular customers.
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price without any discount.
     *
     * @param price the original price
     * @return the same price
     */
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
