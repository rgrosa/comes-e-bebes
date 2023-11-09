package br.com.project.domain.repository;

import br.com.project.domain.entity.AdditionalItemEntity;
import br.com.project.domain.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalItemRepository extends JpaRepository<AdditionalItemEntity, Long> {

    List<AdditionalItemEntity> findAllByItemId(Long restaurantId);
}
