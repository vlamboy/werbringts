package de.htwberlin.werbringts.web.api;

import java.util.List;

public class PersonManipulationRequest {

    private String personName;
    private List<Long> itemsBroughtId;

    public PersonManipulationRequest(String personName, List<Long> itemsBroughtId) {
        this.personName = personName;
        this.itemsBroughtId = itemsBroughtId;
    }

    public PersonManipulationRequest() {}

    public String getPersonName() {return personName;}

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
