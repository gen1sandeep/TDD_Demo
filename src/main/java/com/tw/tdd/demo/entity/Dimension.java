package com.tw.tdd.demo.entity;


import com.tw.tdd.demo.exception.InvalidInputException;

/**
 * Entity class representing length measurement unit.
 * Contains properties of measurement type and value.
 */
public class Dimension {

    private int unitValue;
    private MeasurementUnit unitType;

    public Dimension(int unitValue, MeasurementUnit unitType) {
        this.unitValue = unitValue;
        this.unitType = unitType;
    }
    /* To be decided for refacorting. Not required at this stage

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    public MeasurementUnit getUnitType() {
        return unitType;
    }

    public void setUnitType(MeasurementUnit unitType) {
        this.unitType = unitType;
    }

    */

    /**
     * returns the value of given unit in inches
     * @return
     * @throws InvalidInputException
     */
    public int convertToInches() throws InvalidInputException {

        if (unitValue < 0) {
            throw new InvalidInputException();
        }
        switch (unitType) {
            case INCH:
                return unitValue;
            case FEET:
                return 12 * unitValue;
            case YARD:
                return 36 * unitValue;
        }
        return 0;
    }


}
