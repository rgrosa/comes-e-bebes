package br.com.project.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name =  "ADDITIONAL_ITEM_REL")
public class AdditionalItemRelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ADDITIONAL_ITEM_ID")
    private Long additionalItemId;
    @Column(name = "ITEM_ACQUISITION_REL_ID")
    private Long itemAcquisitionRelId;
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

    public Long getAdditionalItemId() {
        return additionalItemId;
    }

    public void setAdditionalItemId(Long additionalItemId) {
        this.additionalItemId = additionalItemId;
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

    public Long getItemAcquisitionRelId() {
        return itemAcquisitionRelId;
    }

    public void setItemAcquisitionRelId(Long itemAcquisitionRelId) {
        this.itemAcquisitionRelId = itemAcquisitionRelId;
    }
}

