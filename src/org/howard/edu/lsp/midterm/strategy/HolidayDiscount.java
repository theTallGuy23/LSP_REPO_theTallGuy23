package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 15% discount for holiday promotions.
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies a 15% discount.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
