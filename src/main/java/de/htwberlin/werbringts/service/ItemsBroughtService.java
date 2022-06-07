package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.*;
import de.htwberlin.werbringts.web.api.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsBroughtService {

    private final ItemsBroughtRepository itemsBroughtRepository;
    private final ProductRepository productRepository;
    private final PersonRepository personRepository;


    public ItemsBroughtService(ItemsBroughtRepository itemsBroughtRepository, ProductRepository productRepository, PersonRepository personRepository) {
        this.itemsBroughtRepository = itemsBroughtRepository;
        this.productRepository = productRepository;
        this.personRepository = personRepository;
    }

    public List<ItemsBrought> findAll(){
        List<ItemsBroughtEntity> itemsBrought = itemsBroughtRepository.findAll();
        return itemsBrought.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public ItemsBrought create(ItemsBroughtManipulationRequest request){
        var product = productRepository.findById(request.getProductId());
        var person = personRepository.findById(request.getPersonId());
        var itemsBroughtEntity = new ItemsBroughtEntity(person.get(), product.get(),  request.getQuantityBrought());
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
                productEntity.getBringlist().getBringlistId(), transformedListItemsBrought
        );
    }

    private ItemsBrought transformEntity(ItemsBroughtEntity itemsBroughtEntity){
        return new ItemsBrought(
                itemsBroughtEntity.getItemsBroughtId(),
                itemsBroughtEntity.getPerson().getPersonId(),
                itemsBroughtEntity.getProduct().getProductId(),
                itemsBroughtEntity.getQuantityBrought()
        );
    }
}
