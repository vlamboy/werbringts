package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.BringlistEntity;

import java.util.List;

public class ProductCreateRequest {
    private String productName;
    private int quantity;
    private boolean isClosed;
    private BringlistEntity bringlist;
    private List<Long> itemsBroughtId;

    public ProductCreateRequest(String productName, int quantityNeeded, boolean isClosed, BringlistEntity bringlist, List<Long> itemsBroughtId) {
        this.productName = productName;
        this.quantity = quantityNeeded;
        this.isClosed = isClosed;
        this.bringlist = bringlist;
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

    public BringlistEntity getBringlist() {
        return bringlist;
    }

    public void setBringlist(BringlistEntity bringlist) {
        this.bringlist = bringlist;
    }

    //public long getBringlistId() {return bringlistId;}

    //public void setBringlistId(long bringlistId) {this.bringlistId = bringlistId;}

    public List<Long> getItemsBroughtId() {
        return itemsBroughtId;
    }

    public void setItemsBroughtId(List<Long> itemsBroughtId) {
        this.itemsBroughtId = itemsBroughtId;
    }

}
