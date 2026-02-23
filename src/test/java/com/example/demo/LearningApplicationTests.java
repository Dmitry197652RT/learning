package com.example.demo;

import com.example.demo.service.AlgoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearningApplicationTests {

	@Autowired
	private AlgoService algoService;


	@Test
	void shouldReturnNonRepeatebleNumberPositiveCaseTest() {
		int[] numbers = {1, 2, 3, 4, 5, 1, 2, 4, 5};
		int expected = 3;
		int actual = algoService.findNonrepeatedNumber(numbers);
		Assertions.assertEquals(expected, actual);

	}

	@Test
	void shouldReturnNonRepeatebleNumberNegativeCaseTest(){

		// given
		int[] numbers = {1, 2, 3, 4, 5, 1, 2, 4, 5};
		int expected = 4;

		// when
		int actual = algoService.findNonrepeatedNumber(numbers);

		// then
		Assertions.assertNotEquals(expected, actual);

	}

	@Test
	void shouldCheckArrayIsNullTest(){
		// given
		int[] numbers = null;

		int expected = 4;

		// when

		// int actual = algoService.findNonrepeatedNumber(numbers);

		// then

		Assertions.assertThrows(IllegalArgumentException.class, ()-> algoService.findNonrepeatedNumber(numbers));
	}

	@Test
	void shouldThrowExceptionifUnicNumberAbsentTest(){
		// given
		int[] numbers = {1, 2, 3, 4, 5, 1, 2, 4, 5, 3};

		// when

		// then

		Assertions.assertThrows(IllegalArgumentException.class, ()-> algoService.findNonrepeatedNumber(numbers));

	}
}
