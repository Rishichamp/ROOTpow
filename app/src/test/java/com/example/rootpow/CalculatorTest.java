package com.example.rootpow;

import static com.example.rootpow.Calculator.POWER;
import static com.example.rootpow.Calculator.ROOT;
import static com.example.rootpow.Calculator.calculate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void power() {
        assertEquals("Answer=1024.00", calculate("2", "10", POWER));
        assertEquals("Answer=1.41", calculate("2", "0.5", POWER));
        assertEquals("Answer=1.00", calculate("5", "0", POWER));
    }

    @Test
    public void root() {
        assertEquals("Answer=3.00", calculate("27", "3", ROOT));
        assertEquals("Answer=2.00", calculate("16", "4", ROOT));
    }

    @Test
    public void oddRootOfANegativeIsReal() {
        // The old Math.pow(a, 1/b) gave NaN here.
        assertEquals("Answer=-2.00", calculate("-8", "3", ROOT));
    }

    @Test
    public void undefinedResultsAreErrors() {
        assertEquals("Error! No real answer", calculate("-16", "2", ROOT));
        assertEquals("Error! No real answer", calculate("8", "0", ROOT));
        assertEquals("Error! The result is too large", calculate("10", "400", POWER));
    }

    @Test
    public void badInputIsAnErrorNotACrash() {
        assertEquals("None of the fields can be empty", calculate("", "2", POWER));
        assertEquals("Error! Please enter valid numbers", calculate(".", "2", POWER));
    }
}
