package com.example.MathApi.Controller;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.MathApi.pojo.Numbers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MathControllerImplTest {

	IMathController mathController;
	
	@Before
	public void setup() {
		mathController = new MathControllerImpl();
	}
	
	@Test
	public void minimumNumbersTest() {
		Numbers numbers = new Numbers();
		int[] minNumsArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(minNumsArray);
		ResponseEntity response = mathController.minimumNumbers(3, numbers);
		List resultArray = (ArrayList)response.getBody();
		Assert.assertEquals(3, resultArray.size());
	}

	@Test
	public void minimumNumbersInvalidQuantifierLengthTest() {
		Numbers numbers = new Numbers();
		int[] minNumsArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(minNumsArray);
		ResponseEntity response = mathController.minimumNumbers(10, numbers);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void minimumNumbersNullArrayTest() {
		Numbers numbers = new Numbers();
		int[] minNumsArray = {};
		numbers.setListOfNumbers(minNumsArray);
		ResponseEntity response = mathController.minimumNumbers(10, numbers);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void maximumNumbersTest() {
		Numbers numbers = new Numbers();
		int[] minNumsArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(minNumsArray);
		ResponseEntity response = mathController.maximumNumbers(3, numbers);

		List resultArray = (ArrayList)response.getBody();
		Assert.assertEquals(3, resultArray.size());
	}

	@Test
	public void maxmumNumbersInvalidQuantifierLengthTest() {
		Numbers numbers = new Numbers();
		int[] maxNumsArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(maxNumsArray);
		ResponseEntity response = mathController.maximumNumbers(10, numbers);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void maximumNumbersNullArrayTest() {
		Numbers numbers = new Numbers();
		int[] maxNumsArray = {};
		numbers.setListOfNumbers(maxNumsArray);
		ResponseEntity response = mathController.maximumNumbers(10, numbers);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void avarageOfNumbersTest() {
		Numbers numbers = new Numbers();
		int[] minNumsArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(minNumsArray);
		int minNumbers = mathController.averageOfNumbers(numbers);

		Assert.assertNotNull( minNumbers);
	}

	@Test
	public void medianOfNumbersTest() {
		Numbers numbers = new Numbers();
		int[] minNumsArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(minNumsArray);
		double minNumbers = mathController.medianOfNumbers(numbers);

		Assert.assertNotNull( minNumbers);
	}

	@Test
	public void percentileOfNumbersTest() {
		Numbers numbers = new Numbers();
		int[] numbersArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(numbersArray);
		ResponseEntity response = mathController.percentileOfNumbers(3, numbers);
		Assert.assertNotNull((int)response.getBody());
	}

	@Test
	public void percentileOfNumbersInvalidQuantifierLengthTest() {
		Numbers numbers = new Numbers();
		int[] numbersArray = {3,4,2,44,23,24,33,545};
		numbers.setListOfNumbers(numbersArray);
		ResponseEntity response = mathController.minimumNumbers(10, numbers);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void percentileOfNumbersNullArrayTest() {
		Numbers numbers = new Numbers();
		int[] numbersArray = {};
		numbers.setListOfNumbers(numbersArray);
		ResponseEntity response = mathController.minimumNumbers(10, numbers);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
