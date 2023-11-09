package br.com.project.domain.service;

import br.com.project.domain.dto.ItemDTO;
import br.com.project.domain.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDTO> getRestaurantList();

    RestaurantDTO postItem(ItemDTO item);

    RestaurantDTO getRestaurantById(Long restaurantId);

    RestaurantDTO getRestaurantByUserId(Long userId);
}
