package com.spring.spark;

import com.spring.SpringSparkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringSparkApplication.class)
@WebAppConfiguration
public class SpringSparkApplicationTests {

	@Test
	public void contextLoads() {
	}

}
