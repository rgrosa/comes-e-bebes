package br.com.project.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name =  "ACQUISITION")
public class AcquisitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CLIENT_ID")
    private Long clientId;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "DESCRIPTION")
    private String description;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
