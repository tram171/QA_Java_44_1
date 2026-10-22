package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleForm extends TestBase {

    @Test
    void onlyUserName() {
        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=submit]").click();

        $(".mb-1").shouldHave(text(userName));
    }

    @Test
    void incorrectEmail() {
        open("/text-box");
        $("[id=userEmail]").setValue(wrongUserEmail);
        $("[id=submit]").click();

        $("[id=userEmail]").shouldHave(cssClass("field-error" ));
    }
}
