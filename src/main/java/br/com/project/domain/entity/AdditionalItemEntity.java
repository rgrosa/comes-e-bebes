package br.com.project.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name =  "ADDITIONAL_ITEM")
public class AdditionalItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ADDITIONAL_ITEM_NAME")
    private String additionalItemName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "ADDITIONAL_ITEM_IMAGE")
    private String additionalItemImage;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    @Column(name = "INSERTED_AT")
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAdditionalItemImage() {
        return additionalItemImage;
    }

    public void setAdditionalItemImage(String additionalItemImage) {
        this.additionalItemImage = additionalItemImage;
    }
}
