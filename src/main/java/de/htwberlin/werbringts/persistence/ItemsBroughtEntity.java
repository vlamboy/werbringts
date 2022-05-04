package de.htwberlin.werbringts.persistence;

import de.htwberlin.werbringts.web.api.Person;
import de.htwberlin.werbringts.web.api.Product;

import javax.persistence.*;

@Entity(name = "itemsBrought")
public class ItemsBroughtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "person")
    private Person person;

    @Column(name = "product")
    private Product product;

    @Column(name = "quantityBrought")
    private int quantityBrought;

    public ItemsBroughtEntity(long id, Person person, Product product, int quantityBrought) {
        this.id = id;
        this.person = person;
        this.product = product;
        this.quantityBrought = quantityBrought;
    }

    public long getId() {
        return id;
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
