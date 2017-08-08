package com.tw.tdd.demo;


import com.tw.tdd.demo.entity.Dimension;
import com.tw.tdd.demo.entity.MeasurementUnit;
import com.tw.tdd.demo.exception.InvalidInputException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DimensionTest {

    @Test
    public void testLengthConvetorForSuccess() throws InvalidInputException {
        Dimension d1 = new Dimension(1, MeasurementUnit.FEET);
        assertEquals(12,d1.convertToInches());

        d1 = new Dimension(12,MeasurementUnit.INCH);
        assertEquals(12,d1.convertToInches());

        d1 = new Dimension(3,MeasurementUnit.YARD);
        assertEquals(108,d1.convertToInches());
    }

    @Test
    public void testLengthConvetorForFailure()  throws InvalidInputException {
        Dimension d1 = new Dimension(2,MeasurementUnit.FEET);
        assertNotEquals(12,d1.convertToInches());
    }

    @Test
    public void testLengthConvetorForBoundary()  throws InvalidInputException {
        Dimension d1 = new Dimension(0,MeasurementUnit.FEET);
        assertEquals(0,d1.convertToInches());
    }

    @Test(expected = InvalidInputException.class)
    public void testNegativeInput()  throws InvalidInputException {
        Dimension d1 = new Dimension(-1,MeasurementUnit.FEET);
        d1.convertToInches();
    }

}
