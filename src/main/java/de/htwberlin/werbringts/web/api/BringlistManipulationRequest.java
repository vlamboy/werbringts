package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.ProductEntity;

import java.util.List;

public class BringlistManipulationRequest {

    private String listName;
    private String listDescription;
    private List<ProductEntity> product;

    public BringlistManipulationRequest(String listName, String listDescription, List<ProductEntity> product) {
        this.listName = listName;
        this.listDescription = listDescription;
        this.product = product;
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

    public List<ProductEntity> getProduct() {return product;}

    public void setProduct(List<ProductEntity> product) {this.product = product;}
}
