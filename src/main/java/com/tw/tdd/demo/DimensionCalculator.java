package com.tw.tdd.demo;

import com.tw.tdd.demo.entity.Dimension;
import com.tw.tdd.demo.exception.InvalidInputException;

public class DimensionCalculator {
    /**
     * method to calculate the value of given measurement in inches.
     * Take two measurements as input.
     * @param d1
     * @param d2
     * @return
     * @throws InvalidInputException
     */
    public static int getValueInInches(Dimension d1, Dimension d2) throws InvalidInputException {
        return d1.convertToInches()+d2.convertToInches();
    }

}
