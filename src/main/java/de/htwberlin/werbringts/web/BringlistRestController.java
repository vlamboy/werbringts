package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.BringlistService;
import de.htwberlin.werbringts.web.api.Bringlist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
