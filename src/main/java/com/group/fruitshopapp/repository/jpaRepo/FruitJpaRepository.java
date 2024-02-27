package com.group.fruitshopapp.repository.jpaRepo;

import com.group.fruitshopapp.domain.Fruit;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public interface FruitJpaRepository extends JpaRepository <Fruit, Long> {
    Optional<Fruit> findById(Long id);
    Optional<Fruit> findByName (String name);

    List<Fruit> findAllByName(String name);

//    @Query("SELECT f.isSold, SUM(f.price) AS SUM FROM Fruit f WHERE f.name = :name GROUP BY f.isSold")
//    List<Object[]> findSoldStatusTotalPriceByName(@Param("name") String name);
}
