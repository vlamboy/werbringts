package de.htwberlin.werbringts.web.api;

public class ItemsBrought {
    private long id;
    private Person person;
    private Product product;
    private int quantityBrought;

    public ItemsBrought(long id, Person person, Product product, int quantityBrought) {
        this.id = id;
        this.person = person;
        this.product = product;
        this.quantityBrought = quantityBrought;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
