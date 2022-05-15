package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.persistence.ProductRepository;
import de.htwberlin.werbringts.web.api.Person;
import de.htwberlin.werbringts.web.api.PersonManipulationRequest;
import de.htwberlin.werbringts.web.api.Product;
import de.htwberlin.werbringts.web.api.ProductManipulationRequest;
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

    public Product create(ProductManipulationRequest request){
        var productEntity = new ProductEntity(request.getProductName(), request.getQuantity(), request.isClosed(), request.getBringlist());
        productEntity = productRepository.save(productEntity);
        return transformEntity(productEntity);
    }

    public Product update (Long id, ProductManipulationRequest request){
        var productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isEmpty()){
            return null;
        }

        var productEntity = productEntityOptional.get();
        productEntity.setProductName(request.getProductName());
        productEntity.setQuantity(request.getQuantity());
     //   productEntity.setClosed(request.getClosed);
        productEntity.setBringlist(request.getBringlist());
       // productEntity.setItemsBrought(request.getItemsBroughtId());

        return transformEntity(productEntity);
    }

    public boolean deleteById(Long id){
        if (!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
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
