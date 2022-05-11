package de.htwberlin.werbringts.web;
import de.htwberlin.werbringts.service.ProductService;
import de.htwberlin.werbringts.web.api.BringlistCreateRequest;
import de.htwberlin.werbringts.web.api.Product;
import de.htwberlin.werbringts.web.api.ProductCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(path = "/api/v1/products")
    public ResponseEntity<List<Product>> fetchProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(path = "/api/v1/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request) throws URISyntaxException {
        var product =  productService.create(request);
        URI uri = new URI("/api/v1/products" + product.getProductId());
        return ResponseEntity.created(uri).build();
    }

}
