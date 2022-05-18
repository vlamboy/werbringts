package de.htwberlin.werbringts.web.api;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;

import java.util.List;

public class Person {

    private long personId;
    private String personName;
    private List<ItemsBroughtEntity> itemsBrought;


    public Person(long personId, String personName, List<ItemsBroughtEntity> itemsBrought) {
        this.personId = personId;
        this.personName = personName;
        this.itemsBrought = itemsBrought;
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

    public List<ItemsBroughtEntity> getItemsBrought() {
        return itemsBrought;
    }

    public void setItemsBrought(List<ItemsBroughtEntity> itemsBrought) {
        this.itemsBrought = itemsBrought;
    }
}
