package br.com.project.domain.repository;

import br.com.project.domain.entity.AcquisitionEntity;
import br.com.project.domain.entity.ItemAcquisitionRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemAcquisitionRelRepository extends JpaRepository<ItemAcquisitionRelEntity,Long> {

    List<ItemAcquisitionRelEntity> findAllByAcquisitionId(Long acquisitionId);
}
