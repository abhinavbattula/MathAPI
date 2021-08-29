package com.example.MathApi.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MathApi.pojo.Numbers;
/**
 * Sample interface that shows how a service can be implemented with a separate interface.
 * this interface cn be used as programmatic contract.
 * **/
@RestController
public interface IMathController {

	@RequestMapping(value = "/min/{quantifier}", headers = "Accept=application/json", method = RequestMethod.POST)
	ResponseEntity minimumNumbers(@PathVariable int quantifier, @RequestBody Numbers numbers);
	
	@RequestMapping(value = "/max/{quantifier}", headers = "Accept=application/json", method = RequestMethod.POST)
	ResponseEntity maximumNumbers(@PathVariable int quantifier, @RequestBody Numbers numbers);
	
	@RequestMapping(value = "/avg", headers = "Accept=application/json", method = RequestMethod.POST)
	Integer averageOfNumbers(@RequestBody Numbers numbers);
	
	@RequestMapping(value = "/median", headers = "Accept=application/json", method = RequestMethod.POST)
	Double medianOfNumbers(@RequestBody Numbers numbers);
	
	@RequestMapping(value = "/percentile/{quantifier}", headers = "Accept=application/json", method = RequestMethod.POST)
	ResponseEntity percentileOfNumbers(@PathVariable int quantifier, @RequestBody Numbers numbers);
}
