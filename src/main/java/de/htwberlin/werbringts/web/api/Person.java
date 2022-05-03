package de.htwberlin.werbringts.web.api;

public class Person {

    private long personId;
    private String personName;

    public Person(long personId, String personName) {
        this.personId = personId;
        this.personName = personName;
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

}
