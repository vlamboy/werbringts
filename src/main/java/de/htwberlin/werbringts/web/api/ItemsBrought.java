package de.htwberlin.werbringts.web.api;

import java.util.List;

public class ItemsBrought {
    private long itemsBroughtId;
    private Person person;
    private Product product;
    private int quantityBrought;
    private List<Long> personId;

    public ItemsBrought(long itemsBroughtId, Person person, Product product, int quantityBrought, List<Long> personId) {
        this.itemsBroughtId = itemsBroughtId;
        this.person = person;
        this.product = product;
        this.quantityBrought = quantityBrought;
        this.personId = personId;
    }

    public long getItemsBroughtId() {
        return itemsBroughtId;
    }

    public void setItemsBroughtId(long itemsBroughtId) {
        this.itemsBroughtId = itemsBroughtId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityBrought() {
        return quantityBrought;
    }

    public void setQuantityBrought(int quantityBrought) {
        this.quantityBrought = quantityBrought;
    }

    public List<Long> getPersonId() {
        return personId;
    }

    public void setPersonId(List<Long> personId) {
        this.personId = personId;
    }
}
