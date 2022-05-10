package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.BringlistEntity;
import de.htwberlin.werbringts.persistence.BringlistRepository;
import de.htwberlin.werbringts.persistence.ProductEntity;
import de.htwberlin.werbringts.web.api.Bringlist;
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
        return bringlists.stream().map(bringlistEntity -> new Bringlist(bringlistEntity.getBringlistId(), bringlistEntity.getListDescription(), bringlistEntity.getListName(), bringlistEntity.getProducts().stream().map(ProductEntity::getProductId).collect(Collectors.toList()))).collect(Collectors.toList());
    }



}
