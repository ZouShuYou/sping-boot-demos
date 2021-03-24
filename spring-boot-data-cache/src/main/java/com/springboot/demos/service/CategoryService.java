package com.springboot.demos.service;

import com.springboot.demos.domain.Category;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-22 10:14
 */
public interface CategoryService {
    Category getCategory(Integer id);
}
