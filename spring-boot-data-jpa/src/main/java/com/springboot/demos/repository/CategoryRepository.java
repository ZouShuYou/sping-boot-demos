package com.springboot.demos.repository;

import com.springboot.demos.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-22 10:04
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
