package de.htwberlin.werbringts.web.api;

public class Bringer {
    private int amount;
    private String personName;

    public Bringer(String personName, int amount) {
        this.amount = amount;
        this.personName = personName;
    }

    public int getAmount() {
        return amount;
    }

    public String getPersonName() {
        return personName;
    }
}
