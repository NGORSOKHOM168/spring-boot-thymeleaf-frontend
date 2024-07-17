package com.learning;


import java.math.BigInteger;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {

	@Test
	void contextLoads() {
	}
	
	public static void main(String[] args) {
		
		String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		String uuid16digits = uuid.substring(uuid.length() - 16);

		System.out.println(uuid16digits);
	}

}
