package br.com.project.domain.service.imp;

import br.com.project.domain.dto.AdditionalItemDTO;
import br.com.project.domain.dto.ItemDTO;
import br.com.project.domain.dto.RestaurantDTO;
import br.com.project.domain.entity.AdditionalItemEntity;
import br.com.project.domain.entity.ItemEntity;
import br.com.project.domain.entity.RestaurantEntity;
import br.com.project.domain.entity.UserEntity;
import br.com.project.domain.repository.AdditionalItemRepository;
import br.com.project.domain.repository.ItemRepository;
import br.com.project.domain.repository.RestaurantRepository;
import br.com.project.domain.repository.UserRepository;
import br.com.project.domain.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdditionalItemRepository additionalItemRepository;

    @Override
    public List<RestaurantDTO> getRestaurantList() {
        List<RestaurantEntity> restaurantEntityList = restaurantRepository.findAll();
        List<RestaurantDTO> restaurantList = new ArrayList<>();

        for (RestaurantEntity restaurant:  restaurantEntityList) {
            restaurantList.add(makeRestaurantDTO(restaurant));
        }
        return restaurantList;
    }

    private RestaurantDTO makeRestaurantDTO(RestaurantEntity restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurant.getId());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setWorkTime(restaurant.getWorkTime());
        restaurantDTO.setItemList(getItemList(restaurant.getId()));
        restaurantDTO.setRestaurantImage(restaurant.getRestaurantImage());
        return restaurantDTO;
    }

    @Override
    public RestaurantDTO postItem(ItemDTO item) {
        ItemEntity itemEntity;
        if(item.getItemId() != null){
            Optional<ItemEntity> optionalStudentEntity = itemRepository.findById(item.getItemId());
            itemEntity = optionalStudentEntity.orElse(new ItemEntity());
        }else{
            itemEntity = new ItemEntity();
        }
        itemEntity.setItemName(item.getItemName());
        itemEntity.setRestaurantId(item.getRestaurantId());
        itemEntity.setDescription(item.getDescription());
        itemEntity.setPrice(item.getPrice());
        itemEntity.setStatus(item.isStatus());
        itemEntity.setItemImage(item.getItemImage());
        itemEntity = itemRepository.save(itemEntity);
        if(item.getAdditionalItemList() != null){
            saveAdditionalItem(item.getAdditionalItemList(), itemEntity.getId());
        }


        return getRestaurantById(item.getRestaurantId());
    }

    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) {
        Optional<RestaurantEntity> optionalRestaurantEntity = restaurantRepository.findById(restaurantId);
        RestaurantEntity restaurant = optionalRestaurantEntity.orElse( null);
        if (restaurant == null) {
            return null;
        }else {
            return makeRestaurantDTO(restaurant);
        }
    }

    @Override
    public RestaurantDTO getRestaurantByUserId(Long userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        UserEntity user = optionalUserEntity.orElse( null);
        if (user == null || user.getRestaurantId() == null) {
            return null;
        }
        return getRestaurantById(user.getRestaurantId());
    }

    private void saveAdditionalItem(List<AdditionalItemDTO> additionalItemList, Long itemId) {
        for(AdditionalItemDTO additionalItem: additionalItemList){
            AdditionalItemEntity additionalItemEntity;
            if(additionalItem.getAdditionalItemId() != null){
                Optional<AdditionalItemEntity> optionalAdditionalItemEntity = additionalItemRepository.findById(additionalItem.getAdditionalItemId());
                additionalItemEntity = optionalAdditionalItemEntity.orElse(new AdditionalItemEntity());
            }else{
                additionalItemEntity = new AdditionalItemEntity();
            }
            additionalItemEntity.setAdditionalItemName(additionalItem.getAdditionalItemName());
            additionalItemEntity.setItemId(itemId);
            additionalItemEntity.setDescription(additionalItem.getDescription());
            additionalItemEntity.setPrice(additionalItem.getPrice());
            additionalItemEntity.setStatus(additionalItem.isStatus());
            additionalItemEntity.setAdditionalItemImage(additionalItem.getAdditionalItemImage());
            additionalItemRepository.save(additionalItemEntity);
        }
    }

    private List<ItemDTO> getItemList(Long id) {
        List<ItemEntity> itemEntityList = itemRepository.findAllByRestaurantId(id);
        List<ItemDTO> itemList = new ArrayList<>();

        for (ItemEntity item:  itemEntityList) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemId(item.getId());
            itemDTO.setItemName(item.getItemName());
            itemDTO.setDescription(item.getDescription());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setStatus(item.isStatus());
            itemDTO.setAdditionalItemList(getAdditionalItemList(item.getId()));
            itemDTO.setRestaurantId(id);
            itemDTO.setItemImage(item.getItemImage());
            itemList.add(itemDTO);
        }
        return itemList;
    }

    private List<AdditionalItemDTO> getAdditionalItemList(Long itemId) {
        List<AdditionalItemEntity> additionalItemList = additionalItemRepository.findAllByItemId(itemId);
        List<AdditionalItemDTO> additionalItemDTOList = new ArrayList<>();

        for (AdditionalItemEntity additionalItem:  additionalItemList) {
            AdditionalItemDTO additionalItemDTO = new AdditionalItemDTO();
            additionalItemDTO.setAdditionalItemId(additionalItem.getId());
            additionalItemDTO.setAdditionalItemName(additionalItem.getAdditionalItemName());
            additionalItemDTO.setPrice(additionalItem.getPrice());
            additionalItemDTO.setDescription(additionalItemDTO.getDescription());
            additionalItemDTO.setStatus(additionalItemDTO.isStatus());
            additionalItemDTO.setAdditionalItemImage(additionalItemDTO.getAdditionalItemImage());
            additionalItemDTOList.add(additionalItemDTO);
        }
        return additionalItemDTOList;
    }
}
