package com.example.MathApi.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MathApi.pojo.Numbers;

@Component
public class MathControllerImpl implements IMathController {

    /**
     * <p>
     * This method takes Numbers object which contains the numbers array and quantifier
     * @param quantifier
     * @param numbers
     * @returns minimum numbers array which is equal to given quantifier
     * **/
    public ResponseEntity minimumNumbers(@PathVariable int quantifier, @RequestBody Numbers numbers) {

        int[] elements = numbers.getListOfNumbers();

        if (quantifier > elements.length) {
            return new ResponseEntity("Invalid quantifier value", HttpStatus.BAD_REQUEST);
        }
        if (elements.length < 1) {
            return new ResponseEntity("Please pass atLeast one element", HttpStatus.BAD_REQUEST);
        }

        Arrays.stream(elements).distinct();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(quantifier, Collections.reverseOrder());

        return getArrayList(quantifier, elements, maxHeap);
    }

    /**
     * <p>
     * This method takes numbers object which contains the Numbers array and quantifier
     * @param quantifier
     * @param numbers
     * @returns maximun numbers array which is equal to given quantifier
     * **/
    public ResponseEntity maximumNumbers(@PathVariable int quantifier, @RequestBody Numbers numbers) {

        int[] elements = numbers.getListOfNumbers();

        if (quantifier > elements.length) {
            return new ResponseEntity("Invalid quantifier value", HttpStatus.BAD_REQUEST);
        }
        if (elements.length < 1) {
            return new ResponseEntity("Please pass atLeast one element", HttpStatus.BAD_REQUEST);
        }

        Arrays.stream(elements).distinct();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(quantifier);

        return getArrayList(quantifier, elements, minHeap);
    }
    /**
     * <p>
     * This method takes numbers object which contains the numbers array
     * @param numbers
     * @returns average number of the array
     * **/
    public Integer averageOfNumbers(@RequestBody Numbers numbers) {

        int[] elements = numbers.getListOfNumbers();
        int sum = 0;

        for (int element : elements) {
            sum += element;
        }

        return sum / elements.length;
    }

    /**
     * <p>
     * This method takes numbers object which contains the numbers array
     * @param numbers
     * @returns median of the given array
     * **/
    public Double medianOfNumbers(@RequestBody Numbers numbers) {

        int[] elements = numbers.getListOfNumbers();
        Arrays.sort(elements);
        ;
        int medianIndex = elements.length;
        // check for even case
        if (medianIndex % 2 != 0) {
            return (double) elements[medianIndex / 2];
        }

        return (double) ((elements[(medianIndex - 1) / 2] + elements[medianIndex / 2]) / 2.0);
    }

    /**
     * <p>
     * This method takes Numbers object which contains the numbers array and quantifier
     * @param quantifier
     * @param numbers
     * @returns percentile based on the given quantifier
     * **/
    public ResponseEntity percentileOfNumbers(@PathVariable int quantifier, @RequestBody Numbers numbers) {

        int[] elements = numbers.getListOfNumbers();

        if (quantifier > elements.length) {
            return new ResponseEntity("Invalid quantifier value", HttpStatus.BAD_REQUEST);
        }
        if (elements.length < 1) {
            return new ResponseEntity("Please pass atLeast one element", HttpStatus.BAD_REQUEST);
        }
        Arrays.sort(elements);

        int index = (int) Math.ceil(quantifier / 100.0 * elements.length);

        return new ResponseEntity(elements[index - 1], HttpStatus.OK);

    }

    private ResponseEntity getArrayList(@PathVariable int quantifier, int[] elements, PriorityQueue<Integer> heap) {
        for (int element : elements) {
            heap.add(element);

            if (heap.size() == quantifier + 1) {
                heap.poll();
            }
        }

        ArrayList<Integer> minimumNumbers = new ArrayList(heap);

        Collections.sort(minimumNumbers);

        return new ResponseEntity(minimumNumbers, HttpStatus.OK);
    }
}
