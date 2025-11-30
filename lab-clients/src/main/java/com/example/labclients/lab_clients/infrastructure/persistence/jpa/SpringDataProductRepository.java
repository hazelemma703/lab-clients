package com.example.labclients.lab_clients.infrastructure.persistence.jpa;

import com.example.labclients.lab_clients.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM ProductEntity p WHERE p.id = ?1 AND p.quantity > 0")
    boolean isAvailable(Long id);

    @Query("SELECT p.quantity FROM ProductEntity p WHERE p.id = ?1")
    Integer getStock(Long id);
}
