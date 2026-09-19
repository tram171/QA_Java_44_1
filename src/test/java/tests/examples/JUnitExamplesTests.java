package tests.examples;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {

    @BeforeAll

     static void startup() {
        System.out.println("tests startup");
    }

    @AfterAll

    static void testsStopped() {
        System.out.println("tests stopped");
    }

    @BeforeEach

    void startBrowser() {
        System.out.println("browser started");
    }

    @AfterEach

    void closeBrowser() {
        System.out.println("browser closed");
    }

    @Test

    void firstTest() {
    System.out.println("firstTest");
    }

    @Test

    void secondTest() {
        System.out.println("secondTest");
    }
}
