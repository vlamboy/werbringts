package de.htwberlin.werbringts.web;
import de.htwberlin.werbringts.service.ProductService;
import de.htwberlin.werbringts.web.api.Product;
import de.htwberlin.werbringts.web.api.ProductManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Product>> fetchProducts(@RequestParam(required = false) Long bringListId) {
        if (bringListId == null) {
            return ResponseEntity.ok(productService.findAll());
        }

        return ResponseEntity.ok(productService.findByBringlistId(bringListId));
    }

    @PostMapping(path = "/api/v1/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductManipulationRequest request) throws URISyntaxException {
        var product =  productService.create(request);
        URI uri = new URI("/api/v1/products" + product.getProductId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductManipulationRequest request) {
        var product =  productService.update(id, request);
        return product != null? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

//    @PutMapping(path = "/api/v1/products/{id}")
//    public ResponseEntity<Product> updateProductIsClosed(@PathVariable Long id, @RequestBody ProductManipulationRequest request) {
//        var product =  productService.updateIsClosed(id, request);
//        return product != null? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
//    }

    @DeleteMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean successful = productService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
