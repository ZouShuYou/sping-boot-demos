package com.springboot.demos;

import com.springboot.demos.dao.one.UserDao;
import com.springboot.demos.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemosApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	void contextLoads() {
		User user =userDao.findUserByName("zhangsan");
		System.out.println(user);
	}

}
