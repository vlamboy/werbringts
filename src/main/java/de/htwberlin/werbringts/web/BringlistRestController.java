package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.web.api.Bringlist;
import de.htwberlin.werbringts.web.api.Person;
import de.htwberlin.werbringts.web.api.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BringlistRestController {

    private List<Bringlist> bringlists;
    private List<Product> products;
    private List<Person> persons;


    public BringlistRestController() {
        persons = new ArrayList<>();
        persons.add(new Person(1234, "Musterfrau", 0 ));

        products = new ArrayList<>();
        products.add(new Product("Testprodukt", 1, persons, false));

        bringlists = new ArrayList<>();
        bringlists.add(new Bringlist(1, "Musterliste", "Testliste mit Test Attributen", products));
    }

    @GetMapping(path = "/api/v1/bringlists")
    public ResponseEntity<List<Bringlist>> fetchBringlists() {
    return ResponseEntity.ok(bringlists);
    }



}
