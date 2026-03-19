package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for applying different discount behaviors.
 */
public interface DiscountStrategy {

    /**
     * Applies a discount to the given price.
     *
     * @param price the original price
     * @return the discounted price
     */
    double applyDiscount(double price);
}
