package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.persistence.ProductRepository;
import de.htwberlin.werbringts.web.api.Product;
import de.htwberlin.werbringts.web.api.ProductCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        List<ProductEntity> product = productRepository.findAll();
        return product.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Product create(ProductCreateRequest request){
        var productEntity = new ProductEntity(request.getProductName(), request.getQuantity(), request.isClosed());
        productEntity = productRepository.save(productEntity);
        return transformEntity(productEntity);
    }


    private Product transformEntity(ProductEntity productEntity){
        return new Product(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getQuantity(),
                productEntity.isClosed(),
                productEntity.getBringlist().getBringlistId(),
                productEntity.getItemsBrought().stream().map(ItemsBroughtEntity::getItemsBroughtId).collect(Collectors.toList())

        );
    }


}
