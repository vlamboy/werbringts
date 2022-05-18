package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.PersonEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.persistence.ProductRepository;
import de.htwberlin.werbringts.web.api.*;
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
        var productEntity = new ProductEntity(request.getProductName(), request.getQuantity(), request.isClosed());
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
        productEntity.setClosed(request.isClosed());
        productEntity.setItemsBrought(request.getItemsBrought());

        return transformEntity(productEntity);
    }

    public boolean deleteById(Long id){
        if (!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    private Person transformPersonEntity(PersonEntity personEntity){

        return new Person(
                personEntity.getPersonId(),
                personEntity.getPersonName(),
                personEntity.getItemsBrought()
        );
    }

    private Product transformProductEntity(ProductEntity productEntity){
        List <ItemsBrought> transformedListItemsBrought = null;
        for (ItemsBroughtEntity i : productEntity.getItemsBrought()){
            ItemsBrought listIndex = transformItemsBroughtEntity(i);
            transformedListItemsBrought.add(listIndex);
        }

        return new Product(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getQuantity(),
                productEntity.isClosed(),
                transformedListItemsBrought
        );
    }

    private ItemsBrought transformItemsBroughtEntity(ItemsBroughtEntity itemsBroughtEntity){

        return new ItemsBrought(
                itemsBroughtEntity.getItemsBroughtId(),
                transformPersonEntity(itemsBroughtEntity.getPerson()),
                transformProductEntity(itemsBroughtEntity.getProduct()),
                itemsBroughtEntity.getQuantityBrought()
        );
    }

    private Product transformEntity(ProductEntity productEntity){
        List <ItemsBrought> transformedListItemsBrought = null;
        for (ItemsBroughtEntity i : productEntity.getItemsBrought()){
            ItemsBrought listIndex = transformItemsBroughtEntity(i);
            transformedListItemsBrought.add(listIndex);
        }
        return new Product(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getQuantity(),
                productEntity.isClosed(),
                transformedListItemsBrought
        );
    }


}
