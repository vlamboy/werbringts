package de.htwberlin.werbringts.web;


import de.htwberlin.werbringts.service.ItemsBroughtService;
import de.htwberlin.werbringts.web.api.ItemsBrought;
import de.htwberlin.werbringts.web.api.ItemsBroughtManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ItemsBroughtRestController {

    private final ItemsBroughtService itemsBroughtService;

    public ItemsBroughtRestController(ItemsBroughtService itemsBroughtService) {
        this.itemsBroughtService = itemsBroughtService;
    }

    @GetMapping(path = "/api/v1/itemsBrought")
    public ResponseEntity<List<ItemsBrought>> fetchItemsBrought() {
        return ResponseEntity.ok(itemsBroughtService.findAll());
    }

    @PostMapping(path = "/api/v1/itemsBrought")
    public ResponseEntity<Void> createItemsBrought(@RequestBody ItemsBroughtManipulationRequest request) throws URISyntaxException {
        var itemsBrought = itemsBroughtService.create(request);
        URI uri = new URI("/api/v1/itemsBrought" + itemsBrought.getItemsBroughtId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/itemsBrought/{id}")
    public ResponseEntity<ItemsBrought> updateItemsBrought(@PathVariable Long id, @RequestBody ItemsBroughtManipulationRequest request) {
        var itemsBrought =  itemsBroughtService.update(id, request);
        return itemsBrought != null? ResponseEntity.ok(itemsBrought) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/itemsBrought/{id}")
    public ResponseEntity<Void> deleteItemsBrought(@PathVariable Long id) {
        boolean successful = itemsBroughtService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
