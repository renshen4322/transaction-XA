package com.dongnaoedu.tony;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dongnaoedu.tony.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JtaApplication.class)
@EnableTransactionManagement
public class JtaApplicationTests {

	@Autowired
	DemoService demoservice;

	@Test
	public void testTrasaction() {
		try {
			demoservice.inserRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
