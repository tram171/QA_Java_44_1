package tests.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAATestData {

    @Test
    void verifySum() {
        assertEquals(2 + 3, 5);
    }

    @Test
    void aaaTest(){
        // Arrange / Given
        // Act / When
        // Assert / Then
    }

    @Test
    void verifySumWithAaaTest(){
        // Arrange / Given
        int a = 2;
        int b = 3;
        int expectedResult = 5;
        int actualResult;

        // Act / When
        actualResult = a + b;

        // Assert / Then
        assertEquals(expectedResult, actualResult);
    }
}
