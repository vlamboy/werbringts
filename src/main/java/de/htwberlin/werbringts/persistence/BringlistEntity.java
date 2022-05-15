package de.htwberlin.werbringts.persistence;

import de.htwberlin.werbringts.web.api.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "bringlist")
public class BringlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bringlistId")
    private long bringlistId;

    @Column(name = "name", nullable = false)
    private String listName;

    @Column(name = "listDescribtion")
    private String listDescription;

    @OneToMany(mappedBy = "bringlist", fetch = FetchType.EAGER)
    private List<ProductEntity> products = new ArrayList<>();


    public BringlistEntity(String listName, String listDescription) {
        this.listName = listName;
        this.listDescription = listDescription;
    }

    protected BringlistEntity() {}

    public long getBringlistId() {
        return bringlistId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
