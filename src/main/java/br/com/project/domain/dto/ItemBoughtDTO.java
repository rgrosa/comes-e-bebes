package br.com.project.domain.dto;

import java.util.List;

public class ItemBoughtDTO {

    private Long itemId;
    private String itemName;
    private String description;
    private Double itemPrice;

    private List<AdditionalItemDTO> additionalItemList;

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

    public List<AdditionalItemDTO> getAdditionalItemList() {
        return additionalItemList;
    }

    public void setAdditionalItemList(List<AdditionalItemDTO> additionalItemList) {
        this.additionalItemList = additionalItemList;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
