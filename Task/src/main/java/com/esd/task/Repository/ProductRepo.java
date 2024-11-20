package com.esd.task.Repository;

import com.esd.task.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    @Query(value = "select * from products where price between 15 and 30 order by price desc limit 2", nativeQuery = true)
    public List<ProductEntity> customProduct();
}
