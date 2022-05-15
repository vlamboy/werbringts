package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.*;
import de.htwberlin.werbringts.web.api.ItemsBrought;
import de.htwberlin.werbringts.web.api.ItemsBroughtManipulationRequest;
import de.htwberlin.werbringts.web.api.Person;
import de.htwberlin.werbringts.web.api.PersonManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Person create(PersonManipulationRequest request){
        var personEntity = new PersonEntity(request.getPersonName());
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);
    }


    public Person update (Long id, PersonManipulationRequest request){
        var personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isEmpty()){
            return null;
        }

        var personEntity = personEntityOptional.get();
        personEntity.setPersonName(request.getPersonName());
      //  personEntity.setItemsBrought(request.getItemsBroughtId());

        return transformEntity(personEntity);
    }

    public boolean deleteById(Long id){
        if (!personRepository.existsById(id)){
            return false;
        }
        personRepository.deleteById(id);
        return true;
    }

    private Person transformEntity (PersonEntity personEntity){
        return new Person(
                personEntity.getPersonId(),
                personEntity.getPersonName(),
                personEntity.getItemsBrought().stream().map(ItemsBroughtEntity::getItemsBroughtId).collect(Collectors.toList()));
    }

}
