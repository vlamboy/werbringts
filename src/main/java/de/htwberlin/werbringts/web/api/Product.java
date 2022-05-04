package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Product {

    private long productId;
    private String productName;
    private int quantityNeeded;
    private long bringlistId;
    private boolean isClosed;
    private List<Long> itemsBroughtId;

    public Product(long productId, String productName, int quantityNeeded, long bringlistId, boolean isClosed, List<Long> itemsBroughtId) {
        this.productId = productId;
        this.productName = productName;
        this.quantityNeeded = quantityNeeded;
        this.bringlistId = bringlistId;
        this.isClosed = isClosed;
        this.itemsBroughtId = itemsBroughtId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public long getBringlistId() {
        return bringlistId;
    }

    public void setBringlistId(long bringlistId) {
        this.bringlistId = bringlistId;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public List<Long> getItemsBroughtId() {
        return itemsBroughtId;
    }

    public void setItemsBroughtId(List<Long> itemsBroughtId) {
        this.itemsBroughtId = itemsBroughtId;
    }
}
