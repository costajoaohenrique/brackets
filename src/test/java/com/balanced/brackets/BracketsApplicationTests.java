package com.balanced.brackets;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.balanced.brackets.service.BracketsService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BracketsApplicationTests {

	@Autowired
	private BracketsService service;

	@Test
	void isValid() {
		assertTrue(service.isValid("(){}[]"));
		assertTrue(service.isValid("[{()}](){}"));
	}

	@Test
	void isNotValid() {
		assertFalse(service.isValid("[]{()"));
		assertFalse(service.isValid("[{)]"));
	}

}
