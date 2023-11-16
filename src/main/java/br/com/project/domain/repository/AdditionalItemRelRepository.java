package br.com.project.domain.repository;

import br.com.project.domain.entity.AdditionalItemEntity;
import br.com.project.domain.entity.AdditionalItemRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalItemRelRepository extends JpaRepository<AdditionalItemRelEntity, Long>  {

    List<AdditionalItemRelEntity> findAllByItemAcquisitionRelId(Long itemAcquisitionRelId);
}
