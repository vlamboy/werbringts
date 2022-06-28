package de.htwberlin.werbringts.web.api;

import java.util.List;

public class FullBringList {
    private long bringlistId;
    private String listName;
    private String listDescription;
    private List<ProductsBrought> productsBroughtList;

    public FullBringList() {

    }

    public void setBringlistId(long bringlistId) {
        this.bringlistId = bringlistId;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public void setProductsBroughtList(List<ProductsBrought> productsBroughtList) {
        this.productsBroughtList = productsBroughtList;
    }

    public long getBringlistId() {
        return bringlistId;
    }

    public String getListName() {
        return listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public List<ProductsBrought> getProductsBroughtList() {
        return productsBroughtList;
    }
}


