package com.example.rootpow;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Power (a^b) and root (the b-th root of a).
 * Kept free of Android types so it can be unit-tested, and it never throws:
 * every bad input comes back as a message to show the user.
 */
final class Calculator {

    // Positions in the R.array.Root spinner.
    static final int POWER = 0;
    static final int ROOT = 1;

    private Calculator() {
    }

    static String calculate(String first, String second, int operation) {
        if (first.trim().isEmpty() || second.trim().isEmpty()) {
            return "None of the fields can be empty";
        }
        double a;
        double b;
        try {
            a = Double.parseDouble(first.trim());
            b = Double.parseDouble(second.trim());
        } catch (NumberFormatException e) {
            // e.g. a lone "." which the decimal keyboard allows
            return "Error! Please enter valid numbers";
        }
        double r;
        switch (operation) {
            case POWER:
                r = Math.pow(a, b);
                break;
            case ROOT:
                r = root(a, b);
                break;
            default:
                return "Error! Unknown operation";
        }
        if (Double.isNaN(r)) {
            return "Error! No real answer";
        }
        if (Double.isInfinite(r)) {
            return "Error! The result is too large";
        }
        // BigDecimal avoids "-0.00" and scientific notation for large results.
        return "Answer=" + BigDecimal.valueOf(r).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    /** The degree-th root of a; NaN when there is no real answer. */
    static double root(double a, double degree) {
        if (degree == 0) {
            return Double.NaN;
        }
        if (a < 0) {
            // Math.pow(-8, 1.0 / 3) is NaN, but odd roots of negatives are real: -2 for -8.
            boolean oddWholeDegree = degree == Math.rint(degree) && Math.abs(degree) % 2 == 1;
            return oddWholeDegree ? -Math.pow(-a, 1 / degree) : Double.NaN;
        }
        return Math.pow(a, 1 / degree);
    }
}
