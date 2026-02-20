package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* 
 * Contains the business rules for transforming a ProductRecord into a TransformedProduct.
 */
public class ProductTransformer {

    private static final BigDecimal DISCOUNT_FACTOR = new BigDecimal("0.90");
    private static final BigDecimal LOW_THRESHOLD = new BigDecimal("10.00");
    private static final BigDecimal MID_THRESHOLD = new BigDecimal("100.00");
    private static final BigDecimal HIGH_THRESHOLD = new BigDecimal("500.00");

    /* 
     * Applies all transformation rules to a raw product record.
     *
     * @param record input product record
     * @return transformed product
     */
    public TransformedProduct transform(ProductRecord record) {
        int productId = record.getProductId();
        String originalName = record.getName();
        BigDecimal originalPrice = record.getPrice();
        String originalCategory = record.getCategory();

        String transformedName = originalName.toUpperCase();

        BigDecimal finalPrice = applyCategoryDiscount(originalCategory, originalPrice);
        finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);

        String finalCategory = determineFinalCategory(originalCategory, finalPrice);
        String priceRange = determinePriceRange(finalPrice);

        return new TransformedProduct(
                productId,
                transformedName,
                finalPrice,
                finalCategory,
                priceRange
        );
    }

    private BigDecimal applyCategoryDiscount(String category, BigDecimal price) {
        if ("Electronics".equalsIgnoreCase(category)) {
            return price.multiply(DISCOUNT_FACTOR);
        }
        return price;
    }

    private String determineFinalCategory(String originalCategory, BigDecimal finalPrice) {
        String trimmedCategory = originalCategory == null ? "" : originalCategory.trim();

        if ("Electronics".equalsIgnoreCase(originalCategory)
                && finalPrice.compareTo(HIGH_THRESHOLD) > 0) {
            return "Premium Electronics";
        }

        return trimmedCategory;
    }

    private String determinePriceRange(BigDecimal finalPrice) {
        if (finalPrice.compareTo(LOW_THRESHOLD) <= 0) {
            return "Low";
        } else if (finalPrice.compareTo(LOW_THRESHOLD) > 0
                && finalPrice.compareTo(MID_THRESHOLD) <= 0) {
            return "Medium";
        } else if (finalPrice.compareTo(MID_THRESHOLD) > 0
                && finalPrice.compareTo(HIGH_THRESHOLD) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
}