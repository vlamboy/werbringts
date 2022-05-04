package de.htwberlin.werbringts.persistence;

import javax.persistence.*;
import java.util.List;

@Entity(name = "personEntity")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long personId;

    @Column(name = "personName")
    private String personName;


    public PersonEntity(long personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    protected PersonEntity() {}

    public long getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}
