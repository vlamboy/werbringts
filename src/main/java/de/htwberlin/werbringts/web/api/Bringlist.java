package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Bringlist {

    private long listId;
    private String listName;
    private String listDescription;
    private List<Product> productList;

    public Bringlist(long listId, String listName, String listDescription, List<Product> productList) {
        this.listId = listId;
        this.listName = listName;
        this.listDescription = listDescription;
        this.productList = productList;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }
}
