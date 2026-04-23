package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    @Test
    public void testAverageReturnsCorrectAverage() {
        GradeCalculator calculator = new GradeCalculator();

        double result = calculator.average(90, 80, 70);

        assertEquals(80.0, result);
    }

    @Test
    public void testLetterGradeReturnsCorrectGrade() {
        GradeCalculator calculator = new GradeCalculator();

        String result = calculator.letterGrade(85.0);

        assertEquals("B", result);
    }

    @Test
    public void testIsPassingReturnsTrueForPassingAverage() {
        GradeCalculator calculator = new GradeCalculator();

        boolean result = calculator.isPassing(60.0);

        assertTrue(result);
    }

    @test
    public void testIsPassingReturnsFalseForFailingAverage() {
        GradeCalculator calculator = new GradeCalculator();

        boolean result = calculator.isPassing(59.0);

        assertFalse(result);
    }


    @Test
    public void testAverageAllowsMinimumBoundaryScore() {
        GradeCalculator calculator = new GradeCalculator();

        double result = calculator.average(0, 0, 0);

        assertEquals(0.0, result);
    }

    @Test
    public void testAverageAllowsMaximumBoundaryScore() {
        GradeCalculator calculator = new GradeCalculator();

        double result = calculator.average(100, 100, 100);

        assertEquals(100.0, result);
    }

    @Test
    public void testAverageThrowsExceptionForScoreBelowZero() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 90);
        });
    }

    @Test
    public void testAverageThrowsExceptionForScoreAboveOneHundred() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 90);
        });
    }
}
