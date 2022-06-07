package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.PersonEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;

import java.util.List;

public class ItemsBrought {
    private long itemsBroughtId;
    private long personId;
    private long productId;
    private int quantityBrought;

    public ItemsBrought(long itemsBroughtId, long personId, long productId, int quantityBrought) {
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

    public long getPersonId() {
        return personId;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantityBrought() {
        return quantityBrought;
    }

    public void setQuantityBrought(int quantityBrought) {
        this.quantityBrought = quantityBrought;
    }
}
