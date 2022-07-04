package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.PersonService;
import de.htwberlin.werbringts.web.api.Person;
import de.htwberlin.werbringts.web.api.PersonManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(path = "/api/v1/persons")
    public ResponseEntity<Person> createPerson(@RequestBody PersonManipulationRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/v1/persons" + person.getPersonId());
        return ResponseEntity.created(uri).body(person);
    }

    @PutMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody PersonManipulationRequest request) {
        var person =  personService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean successful = personService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
