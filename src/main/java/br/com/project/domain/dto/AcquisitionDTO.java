package br.com.project.domain.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

public class AcquisitionDTO {

    private String description;
    private Long clientId;
    private List<ItemAcquisitionDTO> itemAcquisition;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<ItemAcquisitionDTO> getItemAcquisition() {
        return itemAcquisition;
    }

    public void setItemAcquisition(List<ItemAcquisitionDTO> itemAcquisition) {
        this.itemAcquisition = itemAcquisition;
    }
}
