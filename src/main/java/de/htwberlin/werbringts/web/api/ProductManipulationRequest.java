package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.BringlistEntity;
import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;

import java.util.List;

public class ProductManipulationRequest {
    private String productName;
    private int quantity;
    private boolean isClosed;
    private long bringlistId;

    public ProductManipulationRequest(String productName, int quantity, boolean isClosed, long bringlistId) {
        this.productName = productName;
        this.quantity = quantity;
        this.isClosed = isClosed;
        this.bringlistId = bringlistId;
    }

    public ProductManipulationRequest() {}

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
}
