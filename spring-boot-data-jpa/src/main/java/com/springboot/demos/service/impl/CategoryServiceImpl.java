package com.springboot.demos.service.impl;

import com.springboot.demos.domain.Category;
import com.springboot.demos.repository.CategoryRepository;
import com.springboot.demos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-22 10:17
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getCategory(Integer id) {
        return categoryRepository.getOne(id);
    }
}
