package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.ItemsBroughtEntity;
import de.htwberlin.werbringts.persistence.ItemsBroughtRepository;
import de.htwberlin.werbringts.web.api.Bringlist;
import de.htwberlin.werbringts.web.api.BringlistManipulationRequest;
import de.htwberlin.werbringts.web.api.ItemsBrought;
import de.htwberlin.werbringts.web.api.ItemsBroughtManipulationRequest;
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
        var itemsBroughtEntity = new ItemsBroughtEntity(request.getQuantityBrought());
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
       // itemsBroughtEntity.setPerson(request.getPersonId());
       // itemsBroughtEntity.setProduct(request.getProductId());
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
