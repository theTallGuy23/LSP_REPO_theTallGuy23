package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 10% discount for members.
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies a 10% discount.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
