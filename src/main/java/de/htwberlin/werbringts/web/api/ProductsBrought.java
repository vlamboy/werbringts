package de.htwberlin.werbringts.web.api;

import java.util.List;

public class ProductsBrought {
    private long productId;
    private String productName;
    private int needed;
    private List<Bringer> bringerList;

    public ProductsBrought() {
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setNeeded(int needed) {
        this.needed = needed;
    }

    public void setBringersList(List<Bringer> bringerList) {
        this.bringerList = bringerList;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getNeeded() {
        return needed;
    }

    public List<Bringer> getBringersList() {
        return bringerList;
    }
}
