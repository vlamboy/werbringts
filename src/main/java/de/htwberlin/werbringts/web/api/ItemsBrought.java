package de.htwberlin.werbringts.web.api;

import java.util.List;

public class ItemsBrought {
    private long itemsBroughtId;
    //private Person person;
    private Long personId;
    private Long productId;
    //rivate Product product;
    private int quantityBrought;


    public ItemsBrought(long itemsBroughtId, Long personId, Long productId, int quantityBrought) {
        this.itemsBroughtId = itemsBroughtId;
        this.personId = personId;
        this.productId = productId;
        this.quantityBrought = quantityBrought;
    }

    public long getItemsBroughtId() {
        return itemsBroughtId;
    }

    public void setItemsBroughtId(long itemsBroughtId) {
        this.itemsBroughtId = itemsBroughtId;
    }

    public int getQuantityBrought() {
        return quantityBrought;
    }

    public void setQuantityBrought(int quantityBrought) {
        this.quantityBrought = quantityBrought;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
