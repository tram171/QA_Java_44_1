package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = Paths.get("src/test/resources/pages").toUri().toString();
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
