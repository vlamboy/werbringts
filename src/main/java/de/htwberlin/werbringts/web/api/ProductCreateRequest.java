package de.htwberlin.werbringts.web.api;

import java.util.List;

public class ProductCreateRequest {
    private String productName;
    private int quantity;
    private boolean isClosed;
    private long bringlistId;
    private List<Long> itemsBroughtId;

    public ProductCreateRequest(String productName, int quantityNeeded, boolean isClosed, long bringlistId, List<Long> itemsBroughtId) {
        this.productName = productName;
        this.quantity = quantityNeeded;
        this.isClosed = isClosed;
        this.bringlistId = bringlistId;
        this.itemsBroughtId = itemsBroughtId;
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

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public long getBringlistId() {
        return bringlistId;
    }

    public void setBringlistId(long bringlistId) {
        this.bringlistId = bringlistId;
    }

    public List<Long> getItemsBroughtId() {
        return itemsBroughtId;
    }

    public void setItemsBroughtId(List<Long> itemsBroughtId) {
        this.itemsBroughtId = itemsBroughtId;
    }

}
