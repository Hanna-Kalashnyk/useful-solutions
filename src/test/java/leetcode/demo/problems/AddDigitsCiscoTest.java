package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsCiscoTest {
    AddDigitsCisco number;
    @BeforeEach

    void setUp() {
        number = new AddDigitsCisco();
    }

    @Test
    void digitNumber() {
        int expected = 2;
        Assertions.assertEquals(expected, number.digitNumber(20, 5));
    }
}