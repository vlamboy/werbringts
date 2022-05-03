package de.htwberlin.werbringts.persistence;

import de.htwberlin.werbringts.web.api.Product;

import javax.persistence.*;
import java.util.List;

@Entity (name = "bringlist")
public class BringlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long listId;

    @Column(name = "name", nullable = false)
    private String listName;

    @Column(name = "listDescribtion")
    private String listDescription;

    public BringlistEntity(long listId, String listName, String listDescription, List<ProductEntity> productList) {
        this.listId = listId;
        this.listName = listName;
        this.listDescription = listDescription;
    }

    public long getListId() {
        return listId;
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

}
