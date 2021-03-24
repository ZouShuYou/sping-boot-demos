package com.springboot.demos;

import com.springboot.demos.domain.Category;
import com.springboot.demos.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

@SpringBootTest
class DemosApplicationTests {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CacheManager cacheManager;

	@Test
	void test() {
		categoryRepository.save(new Category(10002,"ranran","2","22"));

		Category c1 = categoryRepository.findByName("ranran");
		System.out.println("第一次查询：" + c1);

		Category c2 = categoryRepository.findByName("ranran");
		System.out.println("第二次查询：" + c2);

	}

}
