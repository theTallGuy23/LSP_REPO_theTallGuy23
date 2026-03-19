package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 20% discount for VIP customers.
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies a 20% discount.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
