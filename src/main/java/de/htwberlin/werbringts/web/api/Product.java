package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Product {

    private long productId;
    private String productName;
    private int quantityNeeded;
    private Bringlist bringlist;
    private boolean isClosed;

    public Product(long productId, String productName, int quantityNeeded, Bringlist bringlist, boolean isClosed) {
        this.productId = productId;
        this.productName = productName;
        this.quantityNeeded = quantityNeeded;
        this.bringlist = bringlist;
        this.isClosed = isClosed;
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

    public Bringlist getBringlist() {
        return bringlist;
    }

    public void setBringlist(Bringlist bringlist) {
        this.bringlist = bringlist;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
