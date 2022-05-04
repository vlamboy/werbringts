package de.htwberlin.werbringts.web.api;

import java.util.List;

public class Person {

    private long personId;
    private String personName;
    private List<Long> itemsBroughtId;


    public Person(long personId, String personName, List<Long> itemsBroughtId) {
        this.personId = personId;
        this.personName = personName;
        this.itemsBroughtId = itemsBroughtId;
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

    public List<Long> getItemsBroughtId() {
        return itemsBroughtId;
    }

    public void setItemsBroughtId(List<Long> itemsBroughtId) {
        this.itemsBroughtId = itemsBroughtId;
    }
}
