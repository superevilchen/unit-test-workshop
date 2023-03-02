package testingil.unittesting.examples.demos.answers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import testingil.unittesting.examples.demos.d00.coverage.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorCsv {

    @ParameterizedTest
    @CsvFileSource(resources= "/calculator.csv")
    void add(int i, int n, int result){
        assertEquals(Calculator.add(i, n), result);
    }
}
