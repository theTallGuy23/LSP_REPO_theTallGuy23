package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/* 
 * Represents a raw product input record parsed from the CSV file.
 */

public class ProductRecord {

    private final int productId;
    private final String name;
    private final BigDecimal price;
    private final String category;

    /* /
     * Constructs a ProductRecord.
     *
     * @param productId numeric product ID
     * @param name      product name
     * @param price     original price
     * @param category  original category
     */
    public ProductRecord(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /*
     *
     * Attempts to parse a ProductRecord from string fields.
     * Returns null if parsing fails for ID or price.
     *
     * @param productIdStr product ID as string
     * @param name         product name
     * @param priceStr     price as string
     * @param category     category
     * @return a ProductRecord instance or null if invalid
     */
    public static ProductRecord fromStrings(
            String productIdStr,
            String name,
            String priceStr,
            String category) {

        try {
            int productId = Integer.parseInt(productIdStr);
            BigDecimal price = new BigDecimal(priceStr);
            return new ProductRecord(productId, name, price, category);
        } catch (NumberFormatException e) {
            return null;
        }
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
}