package com.shivam.inventory.product;

public class ProductRequest {

    private String name;
    private String sku;
    private String category;
    private Integer quantity;
    private Integer reorderLevel;
    private Double price;

    public ProductRequest() {
    }

    public ProductRequest(String name, String sku, String category,
                          Integer quantity, Integer reorderLevel, Double price) {
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
