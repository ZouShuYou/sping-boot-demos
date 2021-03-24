package com.springboot.demos.controller;

import com.springboot.demos.domain.Category;
import com.springboot.demos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-22 10:06
 */

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/category")
    public Category getCategory(@RequestParam(value = "id") Integer id){
        return categoryService.getCategory(id);
    }
}
