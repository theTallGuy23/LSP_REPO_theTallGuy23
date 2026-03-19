package org.howard.edu.lsp.midterm.strategy;

/**
 * Factory class to create DiscountStrategy objects based on customer type.
 */
public class DiscountStrategyFactory {

    /**
     * Returns the appropriate DiscountStrategy based on customer type.
     *
     * @param customerType the type of customer
     * @return the corresponding DiscountStrategy
     */
    public static DiscountStrategy getStrategy(String customerType) {
        switch (customerType.toUpperCase()) {
            case "MEMBER":
                return new MemberDiscount();
            case "VIP":
                return new VipDiscount();
            case "HOLIDAY":
                return new HolidayDiscount();
            case "REGULAR":
            default:
                return new RegularDiscount();
        }
    }
}
