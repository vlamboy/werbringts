package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Product {

    private long productId;
    private String productName;
    private int quatity;
    private boolean isClosed;
    private long bringlistId;
    private List<Long> itemsBroughtId;


    public Product(long productId, String productName, int quatity, boolean isClosed, long bringlistId, List<Long> itemsBroughtId) {
        this.productId = productId;
        this.productName = productName;
        this.quatity = quatity;
        this.isClosed = isClosed;
        this.bringlistId = bringlistId;
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

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
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
