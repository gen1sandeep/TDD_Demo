package com.tw.tdd.demo;

import com.tw.tdd.demo.entity.Dimension;
import com.tw.tdd.demo.entity.MeasurementUnit;
import com.tw.tdd.demo.exception.InvalidInputException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DimensionCalculatorTest {

    @Test
    public void testSameUnitSumForSuccess() throws InvalidInputException {
    Dimension d1 = new Dimension(1, MeasurementUnit.INCH);
    Dimension d2 = new Dimension(2, MeasurementUnit.INCH);
    assertEquals(3, DimensionCalculator.getValueInInches(d1,d2));

    }

    @Test
    public void testSameUnitSumForFailure() throws InvalidInputException   {
        Dimension d1 = new Dimension(1,MeasurementUnit.INCH);
        Dimension d2 = new Dimension(2, MeasurementUnit.INCH);
        assertNotEquals(30, DimensionCalculator.getValueInInches(d1,d2));

    }

    @Test(expected = InvalidInputException.class)
    public void testSameUnitSumForNegativeInput() throws InvalidInputException   {
        Dimension d1 = new Dimension(-1,MeasurementUnit.INCH);
        Dimension d2 = new Dimension(-2, MeasurementUnit.INCH);
        assertEquals(3, DimensionCalculator.getValueInInches(d1,d2));

    }

    @Test
    public void testDiffUnitSumForSuccess() throws InvalidInputException   {
        Dimension d1 = new Dimension(1,MeasurementUnit.INCH);
        Dimension d2 = new Dimension(2, MeasurementUnit.FEET);
        assertEquals(25, DimensionCalculator.getValueInInches(d1,d2));

        d1 = new Dimension(1,MeasurementUnit.YARD);
        d2 = new Dimension(2, MeasurementUnit.FEET);
        assertEquals(60, DimensionCalculator.getValueInInches(d1,d2));

    }

    @Test
    public void testDiffUnitSumForFailure() throws InvalidInputException   {
        Dimension d1 = new Dimension(1,MeasurementUnit.INCH);
        Dimension d2 = new Dimension(2, MeasurementUnit.FEET);
        assertNotEquals(300, DimensionCalculator.getValueInInches(d1,d2));

        d1 = new Dimension(1,MeasurementUnit.YARD);
        d2 = new Dimension(2, MeasurementUnit.FEET);
        assertNotEquals(232, DimensionCalculator.getValueInInches(d1,d2));

    }

}
