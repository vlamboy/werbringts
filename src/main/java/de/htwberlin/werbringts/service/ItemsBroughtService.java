package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.ItemsBroughtRepository;
import de.htwberlin.werbringts.persistence.PersonEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.web.api.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsBroughtService {

    private final ItemsBroughtRepository itemsBroughtRepository;


    public ItemsBroughtService(ItemsBroughtRepository itemsBroughtRepository) {
        this.itemsBroughtRepository = itemsBroughtRepository;
    }

    public List<ItemsBrought> findAll(){
        List<ItemsBroughtEntity> itemsBrought = itemsBroughtRepository.findAll();
        return itemsBrought.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public ItemsBrought create(ItemsBroughtManipulationRequest request){
            var itemsBroughtEntity = new ItemsBroughtEntity(request.getQuantityBrought(), request.getProduct(), request.getPerson());
        itemsBroughtRepository.save(itemsBroughtEntity);
        return transformEntity(itemsBroughtEntity);

    }

    public ItemsBrought update (Long id, ItemsBroughtManipulationRequest request){
        var itemsBroughtEntityOptional = itemsBroughtRepository.findById(id);
        if (itemsBroughtEntityOptional.isEmpty()){
            return null;
        }

        var itemsBroughtEntity = itemsBroughtEntityOptional.get();
        itemsBroughtEntity.setQuantityBrought(request.getQuantityBrought());
        itemsBroughtEntity.setPerson(request.getPerson());
        itemsBroughtEntity.setProduct(request.getProduct());
        return transformEntity(itemsBroughtEntity);
    }


    public boolean deleteById(Long id){
        if (!itemsBroughtRepository.existsById(id)){
            return false;
        }
        itemsBroughtRepository.deleteById(id);
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
            ItemsBrought listIndex = transformEntity(i);
            transformedListItemsBrought.add(listIndex);
        }

        return new Product(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getQuantity(),
                productEntity.isClosed(),

                // geh durch die liste und ruf für jedes Objekt die methode transform auf
                transformedListItemsBrought
        );
    }

    private ItemsBrought transformEntity(ItemsBroughtEntity itemsBroughtEntity){
        return new ItemsBrought(
                itemsBroughtEntity.getItemsBroughtId(),
                transformPersonEntity(itemsBroughtEntity.getPerson()),
                transformProductEntity(itemsBroughtEntity.getProduct()),
                itemsBroughtEntity.getQuantityBrought()
        );
    }
}
