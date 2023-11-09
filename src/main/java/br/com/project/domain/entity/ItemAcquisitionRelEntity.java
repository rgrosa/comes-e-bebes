package br.com.project.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name =  "ITEM_ACQUISITION_REL")
public class ItemAcquisitionRelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "ACQUISITION_ID")
    private Long acquisitionId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ADDITIONAL_ITEM_REL_ID")
    private Long additionalItemRelId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(Long acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAdditionalItemRelId() {
        return additionalItemRelId;
    }

    public void setAdditionalItemRelId(Long additionalItemRelId) {
        this.additionalItemRelId = additionalItemRelId;
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
}
