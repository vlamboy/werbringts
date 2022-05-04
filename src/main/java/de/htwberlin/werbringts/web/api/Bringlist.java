package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Bringlist {

    private long bringlistId;
    private String listName;
    private String listDescription;
    private List<Long> productId;


    public Bringlist(long bringlistId, String listName, String listDescription, List<Long> productId) {
        this.bringlistId = bringlistId;
        this.listName = listName;
        this.listDescription = listDescription;
        this.productId = productId;
    }

    public long getBringlistId() {
        return bringlistId;
    }

    public void setBringlistId(long listId) {
        this.bringlistId = bringlistId;
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
