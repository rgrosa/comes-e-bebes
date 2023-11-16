package br.com.project.domain.dto;

import java.util.List;

public class RestaurantDTO {

    private Long restaurantId;
    private String restaurantName;
    private String address;
    private String workTime;
    private String restaurantImage;
    private List<ItemDTO> itemList;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }
}
