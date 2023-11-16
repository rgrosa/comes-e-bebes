package br.com.project.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name =  "ITEM")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "ITEM_IMAGE")
    private String itemImage;
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
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

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
}
