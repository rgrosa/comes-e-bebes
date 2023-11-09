package br.com.project.domain.service.imp;

import br.com.project.domain.dto.AcquisitionDTO;
import br.com.project.domain.dto.ItemDTO;
import br.com.project.domain.repository.AdditionalItemRepository;
import br.com.project.domain.repository.ItemRepository;
import br.com.project.domain.repository.UserRepository;
import br.com.project.domain.service.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdditionalItemRepository additionalItemRepository;


    @Override
    public String postAcquisition(AcquisitionDTO acquisition) {



            return null;
    }

    @Override
    public Object getAcquisitionHistory(Long userId) {
        return null;
    }
}
