package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.BringlistEntity;
import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;

import java.util.List;

public class ProductManipulationRequest {
    private String productName;
    private int quantity;
    private boolean isClosed;
    private List<ItemsBroughtEntity> itemsBrought;

    public ProductManipulationRequest(String productName, int quantityNeeded, boolean isClosed, List<ItemsBroughtEntity> itemsBrought) {
        this.productName = productName;
        this.quantity = quantityNeeded;
        this.isClosed = isClosed;
        this.itemsBrought = itemsBrought;
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

    public List<ItemsBroughtEntity> getItemsBrought() {return itemsBrought;}

    public void setItemsBrought(List<ItemsBroughtEntity> itemsBrought) {this.itemsBrought = itemsBrought;}
}
