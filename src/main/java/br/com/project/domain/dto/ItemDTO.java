package br.com.project.domain.dto;


import java.util.List;

public class ItemDTO {

    private Long itemId;
    private String itemName;
    private String description;
    private Double price;
    private boolean status;
    private List<AdditionalItemDTO> additionalItemList;
    private Long restaurantId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<AdditionalItemDTO> getAdditionalItemList() {
        return additionalItemList;
    }

    public void setAdditionalItemList(List<AdditionalItemDTO> additionalItemList) {
        this.additionalItemList = additionalItemList;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
