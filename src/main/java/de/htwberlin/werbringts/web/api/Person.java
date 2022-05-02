package de.htwberlin.werbringts.web.api;

public class Person {

    private long personId;
    private String personName;
    private int quantityBrought;

    public Person(long personId, String personName, int quantityBrought) {
        this.personId = personId;
        this.personName = personName;
        this.quantityBrought = quantityBrought;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getQuantityBrought() {
        return quantityBrought;
    }

    public void setQuantityBrought(int quantityBrought) {
        this.quantityBrought = quantityBrought;
    }
}
