package br.com.project.domain.repository;

import br.com.project.domain.entity.AcquisitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcquisitionRepository extends JpaRepository<AcquisitionEntity,Long> {

    List<AcquisitionEntity> findAllByClientId(Long clientId);
}
