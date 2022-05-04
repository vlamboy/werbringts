package de.htwberlin.werbringts.persistence;

import de.htwberlin.werbringts.web.api.Person;

import javax.persistence.*;
import java.util.List;

@Entity(name = "productEntity")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "isClosed")
    private boolean isClosed;

    public ProductEntity(long productId, String productName, int quantity, boolean isClosed) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.isClosed = isClosed;
    }

    protected ProductEntity() {}

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
