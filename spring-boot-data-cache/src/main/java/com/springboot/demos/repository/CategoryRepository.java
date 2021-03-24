package com.springboot.demos.repository;

import com.springboot.demos.domain.Category;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-22 10:04
 */
@Repository
@CacheConfig(cacheNames = "category")
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Cacheable
    @Query("select c from Category c where c.name = ?1")
    Category findByName(String name);
}
