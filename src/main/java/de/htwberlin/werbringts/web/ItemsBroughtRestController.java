package de.htwberlin.werbringts.web;


import de.htwberlin.werbringts.service.ItemsBroughtService;
import de.htwberlin.werbringts.web.api.ItemsBrought;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
