package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.BringlistEntity;
import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.persistence.ProductRepository;
import de.htwberlin.werbringts.web.api.Bringlist;
import de.htwberlin.werbringts.web.api.Product;
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
        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map(productEntity -> new Product(productEntity.getProductId(), productEntity.getProductName(), productEntity.getQuantity(), productEntity.isClosed(), productEntity.getBringlist().getBringlistId(), productEntity.getItemsBrought().stream().map(ItemsBroughtEntity::getItemsBroughtId).collect(Collectors.toList()))).collect(Collectors.toList());
    }


}
