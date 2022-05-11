package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.BringlistService;
import de.htwberlin.werbringts.web.api.Bringlist;
import de.htwberlin.werbringts.web.api.BringlistCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> createBringlist(@RequestBody BringlistCreateRequest request) throws URISyntaxException {
        var bringlist =  bringlistService.create(request);
                URI uri = new URI("/api/v1/bringlists" + bringlist.getBringlistId());
        return ResponseEntity.created(uri).build();
    }

}
