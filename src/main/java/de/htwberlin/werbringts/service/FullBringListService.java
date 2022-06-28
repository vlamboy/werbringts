package de.htwberlin.werbringts.service;

import de.htwberlin.werbringts.persistence.*;
import de.htwberlin.werbringts.web.api.Bringer;
import de.htwberlin.werbringts.web.api.FullBringList;
import de.htwberlin.werbringts.web.api.ProductsBrought;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullBringListService {

    private final ProductRepository productRepository;
    private final PersonRepository personRepository;
    private final ItemsBroughtRepository itemsBroughtRepository;
    private final BringlistRepository bringlistRepository;

    public FullBringListService(ProductRepository productRepository, PersonRepository personRepository,
                                ItemsBroughtRepository itemsBroughtRepository, BringlistRepository bringlistRepository) {
        this.productRepository = productRepository;
        this.personRepository = personRepository;
        this.itemsBroughtRepository = itemsBroughtRepository;
        this.bringlistRepository = bringlistRepository;
    }

    public FullBringList findByBringlistId(Long id){
        BringlistEntity bringlistEntity = bringlistRepository.findById(id).orElseThrow();
        FullBringList fullBringList = new FullBringList();
        fullBringList.setBringlistId(bringlistEntity.getBringlistId());
        fullBringList.setListName(bringlistEntity.getListName());
        fullBringList.setListDescription(bringlistEntity.getListDescription());

        List<ProductEntity> product = productRepository.findAllByBringlist(bringlistEntity);
        List<ProductsBrought> productsBroughtList = new ArrayList<>();
        for (ProductEntity productEntity : product) {
            ProductsBrought productsBrought = new ProductsBrought();
            productsBrought.setProductName(productEntity.getProductName());
            productsBrought.setProductId(productEntity.getProductId());
            productsBrought.setNeeded(productEntity.getQuantity());

            List<Bringer> bringers = new ArrayList<>();
            for (ItemsBroughtEntity itemsBroughtEntity : productEntity.getItemsBrought()) {
                Bringer bringer = new Bringer(
                        itemsBroughtEntity.getPerson().getPersonName(), itemsBroughtEntity.getQuantityBrought()
                );
                bringers.add(bringer);
            }
            productsBrought.setBringersList(bringers);
            productsBroughtList.add(productsBrought);
        }

        fullBringList.setProductsBroughtList(productsBroughtList);

        return fullBringList;
    }
}
