package br.com.project.domain.dto;

import java.util.List;

public class ItemAcquisitionDTO {

    private ItemDTO item;
    private String description;

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
