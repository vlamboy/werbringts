package de.htwberlin.werbringts.web.api;

public class Product {

    private String productName;
    private int quantity;
    private int quantityClosed;
    private boolean status;


    public Product(String productName, int quantity, int quantityClosed, boolean status) {
        this.productName = productName;
        this.quantity = quantity;
        this.quantityClosed = quantityClosed;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityClosed() {
        return quantityClosed;
    }

    public void setQuantityClosed(int quantityClosed) {
        this.quantityClosed = quantityClosed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
