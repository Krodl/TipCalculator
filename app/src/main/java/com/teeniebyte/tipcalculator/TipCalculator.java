package com.teeniebyte.tipcalculator;

/**
 * Created by kteen on 1/28/2018.
 */

public class TipCalculator {
    private float tip;
    private float bill;

    public TipCalculator(float newTip, float newBill ) {
        setTip( newTip );
        setBill( newBill );
    }

    public float getTip( ) {
        return tip;
    }

    public float getBill( ) {
        return bill;
    }

    public void setTip( float newTip ) {
        if( newTip > 0 )
            tip = newTip;
    }

    public void setBill( float newBill ) {
        if( newBill > 0 )
            bill = newBill;
    }

    public float tipAmount( ) {
        tip = (float) .1;
        return bill * tip;
    }

    public float totalAmount( ) {
        return bill + tipAmount( );
    }
}