package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.*;
import de.htwberlin.werbringts.web.api.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BringlistRepository bringlistRepository;

    public ProductService(ProductRepository productRepository, BringlistRepository bringlistRepository) {
        this.productRepository = productRepository;
        this.bringlistRepository = bringlistRepository;
    }

    public List<Product> findAll(){
        List<ProductEntity> product = productRepository.findAll();
        return product.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Product create(ProductManipulationRequest request){
        Optional<BringlistEntity> bringlist = bringlistRepository.findById(request.getBringlistId());
        var productEntity = new ProductEntity(request.getProductName(), request.getQuantity(), request.isClosed(), bringlist.get());
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
                personEntity.getPersonName()
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
                productEntity.getBringlist().getBringlistId(), transformedListItemsBrought
        );
    }

    private ItemsBrought transformItemsBroughtEntity(ItemsBroughtEntity itemsBroughtEntity){

        return new ItemsBrought(
                itemsBroughtEntity.getItemsBroughtId(),
                itemsBroughtEntity.getPerson().getPersonId(),
                itemsBroughtEntity.getProduct().getProductId(),
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
                productEntity.getBringlist().getBringlistId(), transformedListItemsBrought
        );
    }


}
