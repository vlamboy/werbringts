package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.BringlistEntity;
import de.htwberlin.werbringts.persistence.BringlistRepository;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.web.api.Bringlist;
import de.htwberlin.werbringts.web.api.BringlistCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BringlistService {

    private final BringlistRepository bringlistRepository;

    public BringlistService(BringlistRepository bringlistRepository) {
        this.bringlistRepository = bringlistRepository;
    }

    public List<Bringlist> findAll(){
        List<BringlistEntity> bringlist = bringlistRepository.findAll();
        return bringlist.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Bringlist create(BringlistCreateRequest request){
        var bringlistEntity = new BringlistEntity(request.getListName(), request.getListDescription());
        bringlistEntity = bringlistRepository.save(bringlistEntity);

        return transformEntity(bringlistEntity);
    }

    public boolean deleteById(Long id){
        if (!bringlistRepository.existsById(id)){
            return false;
        }
        bringlistRepository.deleteById(id);
        return true;
    }

    private Bringlist transformEntity(BringlistEntity bringlistEntity){

        return new Bringlist(
                bringlistEntity.getBringlistId(),
                bringlistEntity.getListName(),
                bringlistEntity.getListDescription(),
                bringlistEntity.getProducts().stream().map(ProductEntity::getProductId).collect(Collectors.toList())
        );
    }
}
