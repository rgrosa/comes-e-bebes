package br.com.project.domain.service;

import br.com.project.domain.dto.AcquisitionDTO;
import br.com.project.domain.dto.ItemDTO;

public interface AcquisitionService {


    String postAcquisition(AcquisitionDTO acquisitionDTO);

    Object getAcquisitionHistory(Long userId);
}
