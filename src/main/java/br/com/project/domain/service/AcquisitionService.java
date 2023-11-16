package br.com.project.domain.service;

import br.com.project.domain.dto.AcquisitionDTO;
import br.com.project.domain.dto.ItemAcquisitionReturnDTO;
import br.com.project.domain.dto.ItemDTO;

import java.util.List;

public interface AcquisitionService {


    ItemAcquisitionReturnDTO postAcquisition(AcquisitionDTO acquisitionDTO);

    List<ItemAcquisitionReturnDTO> getAcquisitionHistory(Long userId);
}
