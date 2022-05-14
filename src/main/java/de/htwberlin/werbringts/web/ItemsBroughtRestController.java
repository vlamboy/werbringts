package de.htwberlin.werbringts.web;


import de.htwberlin.werbringts.service.ItemsBroughtService;
import de.htwberlin.werbringts.web.api.ItemsBrought;
import de.htwberlin.werbringts.web.api.ItemsBroughtCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> createItemsBrought(@RequestBody ItemsBroughtCreateRequest request) throws URISyntaxException {
        var itemsBrought = itemsBroughtService.create(request);
        URI uri = new URI("/api/v1/itemsBrought" + itemsBrought.getItemsBroughtId());
        return ResponseEntity.created(uri).build();
    }

}
