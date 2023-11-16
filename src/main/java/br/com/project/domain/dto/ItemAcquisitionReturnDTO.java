package br.com.project.domain.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

public class ItemAcquisitionReturnDTO {

    private Long acquisitionId;
    private Long clientId;
    private Double price;
    private String description;
    private LocalDateTime createdAt;
    private List<ItemBoughtDTO> itemBoughtList;


    public Long getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(Long acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ItemBoughtDTO> getItemBoughtList() {
        return itemBoughtList;
    }

    public void setItemBoughtList(List<ItemBoughtDTO> itemBoughtList) {
        this.itemBoughtList = itemBoughtList;
    }
}
