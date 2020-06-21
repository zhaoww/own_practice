package com.zww.sboot;

import com.zww.sboot.bean.TestBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ImportBeanDefinitionRegistrarTest {

	@Resource
	private TestBean testBean;
	@Test
	void contextLoads() {
		System.out.println(testBean);
	}

}
