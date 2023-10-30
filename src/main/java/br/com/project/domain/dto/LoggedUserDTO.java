package br.com.project.domain.dto;

import java.time.LocalDateTime;

public class LoggedUserDTO {

    private Long id;
    private String username;
    private String password;
    private String jwtToken;
    private Integer userTypeId;
    private String address;
    private String registrationDocument;
    private LocalDateTime updatedAt;
    private LocalDateTime insertedAt;
    private Long restaurantId;
    private Boolean status;

    public LoggedUserDTO(Long id, String username, String password, String jwtToken, Integer userTypeId, String address, String registrationDocument, LocalDateTime updatedAt, LocalDateTime insertedAt, Long restaurantId, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jwtToken = jwtToken;
        this.userTypeId = userTypeId;
        this.address = address;
        this.registrationDocument = registrationDocument;
        this.updatedAt = updatedAt;
        this.insertedAt = insertedAt;
        this.restaurantId = restaurantId;
        this.status = status;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistrationDocument() {
        return registrationDocument;
    }

    public void setRegistrationDocument(String registrationDocument) {
        this.registrationDocument = registrationDocument;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(LocalDateTime insertedAt) {
        this.insertedAt = insertedAt;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
