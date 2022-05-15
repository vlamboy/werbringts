package de.htwberlin.werbringts.web.api;

import java.util.List;

public class BringlistManipulationRequest {

    private String listName;
    private String listDescription;
    private List<Long> productId;

    public BringlistManipulationRequest(String listName, String listDescription, List<Long> productId) {
        this.listName = listName;
        this.listDescription = listDescription;
        this.productId = productId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public List<Long> getProductId() {
        return productId;
    }

    public void setProductId(List<Long> productId) {
        this.productId = productId;
    }
}
