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
        List<BringlistEntity> bringlists = bringlistRepository.findAll();
        return bringlists.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Bringlist create(BringlistCreateRequest request){
        var bringlistEntity = new BringlistEntity(request.getListName(), request.getListDescription());
        bringlistEntity = bringlistRepository.save(bringlistEntity);

        return transformEntity(bringlistEntity);
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
