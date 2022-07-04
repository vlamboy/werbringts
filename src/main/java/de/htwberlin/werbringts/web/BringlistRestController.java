package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.BringlistService;
import de.htwberlin.werbringts.web.api.Bringlist;
import de.htwberlin.werbringts.web.api.BringlistManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BringlistRestController {

    private final BringlistService bringlistService;

    public BringlistRestController(BringlistService bringlistService) {
        this.bringlistService = bringlistService;
    }


    @GetMapping(path = "/api/v1/bringlists")
    public ResponseEntity<List<Bringlist>> fetchBringlists() {
        return ResponseEntity.ok(bringlistService.findAll());
    }


    @PostMapping (path = "/api/v1/bringlists")
    public ResponseEntity<Bringlist> createBringlist(@RequestBody BringlistManipulationRequest request) throws URISyntaxException {
        var bringlist =  bringlistService.create(request);
        URI uri = new URI("/api/v1/bringlists/" + bringlist.getBringlistId());
        return ResponseEntity
                .created(uri)
                .header("Access-Control-Expose-Headers", "Location")
                .body(bringlist);
    }

    @PutMapping(path = "/api/v1/bringlists/{id}")
    public ResponseEntity<Bringlist> updateBringlist(@PathVariable Long id, @RequestBody BringlistManipulationRequest request) {
        var bringlist =  bringlistService.update(id, request);
        return bringlist != null? ResponseEntity.ok(bringlist) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/bringlists/{id}")
    public ResponseEntity<Void> deleteBringlist(@PathVariable Long id) {
        boolean successful = bringlistService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
