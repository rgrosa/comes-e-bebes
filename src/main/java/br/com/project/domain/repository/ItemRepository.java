package br.com.project.domain.repository;

import br.com.project.domain.entity.ItemEntity;
import br.com.project.domain.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findAllByRestaurantId(Long restaurantId);

}
