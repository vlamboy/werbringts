package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Product {

    private String productName;
    private int quantity;
    private List<Person> person;
    private boolean isClosed;


    public Product(String productName, int quantity, List<Person> person, boolean isClosed) {
        this.productName = productName;
        this.quantity = quantity;
        this.person = person;
        this.isClosed = isClosed;
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

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        this.isClosed = closed;
    }


}
