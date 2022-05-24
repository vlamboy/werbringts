package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.PersonEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;

import javax.swing.text.html.parser.Entity;

public class ItemsBroughtManipulationRequest {
    private long personId;
    private long productId;
    private int quantityBrought;


    public ItemsBroughtManipulationRequest(long personId, long productId, int quantityBrought) {
        this.personId = personId;
        this.productId = productId;
        this.quantityBrought = quantityBrought;
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
