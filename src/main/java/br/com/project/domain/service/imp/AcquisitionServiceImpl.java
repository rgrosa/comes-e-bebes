package br.com.project.domain.service.imp;

import br.com.project.domain.dto.*;
import br.com.project.domain.entity.AcquisitionEntity;
import br.com.project.domain.entity.AdditionalItemRelEntity;
import br.com.project.domain.entity.ItemAcquisitionRelEntity;
import br.com.project.domain.entity.ItemEntity;
import br.com.project.domain.repository.*;
import br.com.project.domain.service.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AdditionalItemRepository additionalItemRepository;

    @Autowired
    AcquisitionRepository acquisitionRepository;

    @Autowired
    ItemAcquisitionRelRepository itemAcquisitionRelRepository;

    @Autowired
    AdditionalItemRelRepository additionalItemRelRepository;


    @Override
    public ItemAcquisitionReturnDTO postAcquisition(AcquisitionDTO acquisition) {
        Double totalPrice = 0.0;
        AcquisitionEntity acquisitionEntity = new AcquisitionEntity();
        acquisitionEntity.setClientId(acquisition.getClientId());
        acquisitionEntity.setDescription(acquisition.getDescription());
        acquisitionEntity = acquisitionRepository.save(acquisitionEntity);
        for(ItemAcquisitionDTO item: acquisition.getItemAcquisition()){
            ItemAcquisitionRelEntity itemEntity = new ItemAcquisitionRelEntity();
            totalPrice = (totalPrice + itemRepository.findById(item.getItem().getItemId()).get().getPrice());
            itemEntity.setAcquisitionId(acquisitionEntity.getId());
            itemEntity.setDescription(item.getDescription());
            itemEntity.setItemId(item.getItem().getItemId());
            itemEntity = itemAcquisitionRelRepository.save(itemEntity);
            for (AdditionalItemDTO additionalItem : item.getItem().getAdditionalItemList()){
                AdditionalItemRelEntity additionalItemRelEntity = new AdditionalItemRelEntity();
                additionalItemRelEntity.setAdditionalItemId(additionalItem.getAdditionalItemId());
                additionalItemRelEntity.setItemAcquisitionRelId(itemEntity.getId());
                additionalItemRelRepository.save(additionalItemRelEntity);
                totalPrice = (totalPrice + additionalItem.getAdditionalItemId());
            }
        }
        acquisitionEntity.setPrice(totalPrice);
        acquisitionRepository.save(acquisitionEntity);
        return getAcquisitionById(acquisitionEntity.getId());
    }


    private ItemAcquisitionReturnDTO getAcquisitionById(Long acquisitionId) {
        return makeItemAcquisitionReturnDTO(acquisitionRepository.findById(acquisitionId).get());
    }

    @Override
    public List<ItemAcquisitionReturnDTO> getAcquisitionHistory(Long userId) {
        List<ItemAcquisitionReturnDTO>  itemAcquisitionReturnList  = new ArrayList<>();
        List<AcquisitionEntity> acquisitionEntityList =  acquisitionRepository.findAllByClientId(userId);

        for(AcquisitionEntity acquisitionEntity :acquisitionEntityList){
            itemAcquisitionReturnList.add(makeItemAcquisitionReturnDTO(acquisitionEntity));
        }
        return itemAcquisitionReturnList;
    }

    private ItemAcquisitionReturnDTO makeItemAcquisitionReturnDTO(AcquisitionEntity acquisitionEntity) {
        ItemAcquisitionReturnDTO itemAcquisitionReturn = new ItemAcquisitionReturnDTO();
        List<ItemBoughtDTO> itemBoughtList = new ArrayList<>();
        itemAcquisitionReturn.setAcquisitionId(acquisitionEntity.getId());
        itemAcquisitionReturn.setCreatedAt(acquisitionEntity.getCreatedAt());
        itemAcquisitionReturn.setClientId(acquisitionEntity.getClientId());
        itemAcquisitionReturn.setPrice(acquisitionEntity.getPrice());
        itemAcquisitionReturn.setDescription(acquisitionEntity.getDescription());
        List<ItemAcquisitionRelEntity>  itemAcquisitionRelEntity = itemAcquisitionRelRepository.findAllByAcquisitionId(
                acquisitionEntity.getId()
        );
        for(ItemAcquisitionRelEntity itemAcquisitionRel :itemAcquisitionRelEntity){
           var item = itemRepository.findById(itemAcquisitionRel.getItemId()).get();
           ItemBoughtDTO itemBoughtDTO = new ItemBoughtDTO();
            List<AdditionalItemDTO> additionalItemList = new ArrayList<>();
            itemBoughtDTO.setDescription(itemAcquisitionRel.getDescription());
            itemBoughtDTO.setItemId(item.getId());
            itemBoughtDTO.setItemPrice(item.getPrice());
            itemBoughtDTO.setItemName(item.getItemName());
            List<AdditionalItemRelEntity> additionalItemRelEntityList = additionalItemRelRepository.findAllByItemAcquisitionRelId(
                    itemAcquisitionRel.getAcquisitionId()
            );
            for(AdditionalItemRelEntity additionalItemRel: additionalItemRelEntityList){
                AdditionalItemDTO additionalItem =  new AdditionalItemDTO();
                var additionalItemEntity = additionalItemRepository.findById(additionalItemRel.getId()).get();
                additionalItem.setAdditionalItemName(additionalItemEntity.getAdditionalItemName());
                additionalItem.setPrice(additionalItemEntity.getPrice());
                additionalItem.setAdditionalItemId(additionalItemEntity.getId());
                additionalItemList.add(additionalItem);
            }
            itemBoughtDTO.setAdditionalItemList(additionalItemList);
            itemBoughtList.add(itemBoughtDTO);
        }
        itemAcquisitionReturn.setItemBoughtList(itemBoughtList);
        return itemAcquisitionReturn;
    }
}