package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/* 
 * Represents a fully transformed product ready to be written to the output CSV.
 */
public class TransformedProduct {

    private final int productId;
    private final String name;
    private final BigDecimal price;
    private final String category;
    private final String priceRange;

    /* 
     * Constructs a TransformedProduct.
     *
     * @param productId  product ID
     * @param name       transformed name
     * @param price      final price (rounded to two decimals)
     * @param category   final category
     * @param priceRange derived price range label
     */
    public TransformedProduct(
            int productId,
            String name,
            BigDecimal price,
            String category,
            String priceRange) {

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Returns the price as a plain string with exact scale,
     * matching Assignment 2 output.
     *
     * @return price string
     */
    public String getPriceAsString() {
        return price.toPlainString();
    }
}