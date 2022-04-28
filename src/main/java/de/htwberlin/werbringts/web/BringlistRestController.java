package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.web.api.Bringlist;
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

    public BringlistRestController() {
        products = new ArrayList<>();
        products.add(new Product("Testprodukt", 1, 0, false));

        bringlists = new ArrayList<>();
        bringlists.add(new Bringlist(1, "Musterliste", products));
    }

    @GetMapping(path = "/api/v1/bringlists")
    public ResponseEntity<List<Bringlist>> fetchBringlists() {
    return ResponseEntity.ok(bringlists);
    }



}
