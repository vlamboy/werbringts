package de.htwberlin.werbringts.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId")
    private long personId;

    @Column(name = "personName")
    private String personName;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<ItemsBroughtEntity> itemsBrought = new ArrayList<>();

    public PersonEntity(String personName, List<ItemsBroughtEntity> itemsBrought) {
        this.personName = personName;
        this.itemsBrought = itemsBrought;
    }

    public PersonEntity(String personName) {
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

    public List<ItemsBroughtEntity> getItemsBrought() {
        return itemsBrought;
    }

    public void setItemsBrought(List<ItemsBroughtEntity> itemsBrought) {
        this.itemsBrought = itemsBrought;
    }
}
