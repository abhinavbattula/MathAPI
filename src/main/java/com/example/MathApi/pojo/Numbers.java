package com.example.MathApi.pojo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Numbers {

	@JsonProperty
	private int[] ListOfNumbers;

	@JsonProperty
	public int[] getListOfNumbers() {
		return ListOfNumbers;
	}
	
	@JsonProperty
	public void setListOfNumbers(int[] listOfNumbers) {
		ListOfNumbers = listOfNumbers;
	}

	
}
