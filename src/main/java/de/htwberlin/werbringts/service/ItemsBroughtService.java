package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.ItemsBroughtRepository;
import de.htwberlin.werbringts.persistence.PersonEntity;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.web.api.ItemsBrought;
import de.htwberlin.werbringts.web.api.ItemsBroughtCreateRequest;
import de.htwberlin.werbringts.web.api.Product;
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

    public ItemsBrought create(ItemsBroughtCreateRequest request){
        var itemsBroughtEntity = new ItemsBroughtEntity(request.getQuantityBrought());
        itemsBroughtRepository.save(itemsBroughtEntity);
        return transformEntity(itemsBroughtEntity);

    }

    public boolean deleteById(Long id){
        if (!itemsBroughtRepository.existsById(id)){
            return false;
        }
        itemsBroughtRepository.deleteById(id);
        return true;
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
