package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.PersonEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;

import javax.swing.text.html.parser.Entity;

public class ItemsBroughtManipulationRequest {
    private PersonEntity person;
    private ProductEntity product;
    private int quantityBrought;

    public ItemsBroughtManipulationRequest(PersonEntity person, ProductEntity product, int quantityBrought) {
        this.person = person;
        this.product = product;
        this.quantityBrought = quantityBrought;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantityBrought() {
        return quantityBrought;
    }

    public void setQuantityBrought(int quantityBrought) {
        this.quantityBrought = quantityBrought;
    }
}
