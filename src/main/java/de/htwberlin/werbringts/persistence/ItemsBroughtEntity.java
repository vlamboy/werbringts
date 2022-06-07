package de.htwberlin.werbringts.persistence;

import de.htwberlin.werbringts.web.api.Person;
import de.htwberlin.werbringts.web.api.Product;

import javax.persistence.*;

@Entity(name = "itemsBrought")
public class ItemsBroughtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemsBroughtId")
    private long itemsBroughtId;

    @Column(name = "quantityBrought")
    private int quantityBrought;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private ProductEntity product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "personId", referencedColumnName = "personId")
    private PersonEntity person;

    public ItemsBroughtEntity(PersonEntity person, ProductEntity product, int quantityBrought) {
        this.quantityBrought = quantityBrought;
        this.product = product;
        this.person = person;
    }

    protected ItemsBroughtEntity() {}

    public long getItemsBroughtId() {return itemsBroughtId;}

    public int getQuantityBrought() {return quantityBrought;}

    public void setQuantityBrought(int quantityBrought) {this.quantityBrought = quantityBrought;}

    public ProductEntity getProduct() {return product;}

    public void setProduct(ProductEntity product) {this.product = product;}

    public PersonEntity getPerson() {return person;}

    public void setPerson(PersonEntity person) {this.person = person;}

}
