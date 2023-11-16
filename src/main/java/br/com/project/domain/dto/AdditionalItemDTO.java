package br.com.project.domain.dto;

public class AdditionalItemDTO {

    private Long additionalItemId;
    private String additionalItemName;
    private String description;
    private Double price;
    private boolean status;
    private String additionalItemImage;

    public Long getAdditionalItemId() {
        return additionalItemId;
    }

    public void setAdditionalItemId(Long additionalItemId) {
        this.additionalItemId = additionalItemId;
    }

    public String getAdditionalItemName() {
        return additionalItemName;
    }

    public void setAdditionalItemName(String additionalItemName) {
        this.additionalItemName = additionalItemName;
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

    public String getAdditionalItemImage() {
        return additionalItemImage;
    }

    public void setAdditionalItemImage(String additionalItemImage) {
        this.additionalItemImage = additionalItemImage;
    }
}
