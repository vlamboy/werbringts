package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.FullBringListService;
import de.htwberlin.werbringts.web.api.FullBringList;
import de.htwberlin.werbringts.web.api.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FullBringListRestController {

    private final FullBringListService fullBringListService;

    public FullBringListRestController(FullBringListService fullBringListService) {
        this.fullBringListService = fullBringListService;
    }

    @GetMapping(path = "/api/v1/fullbringlist")
    public ResponseEntity<FullBringList> fetchProducts(@RequestParam(required = false) Long id) {
        return ResponseEntity.ok(fullBringListService.findByBringlistId(id));
    }
}
