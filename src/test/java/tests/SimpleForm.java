package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleForm extends TestBase {

    @Test
    void onlyUserName() {
        open("/text-box");
        $("[id=userName]").setValue("Довольно");
        $("[id=submit]").click();

        $(".mb-1").shouldHave(text("Довольно"));
    }

    @Test
    void incorrectEmail() {
        open("/text-box");
        $("[id=userEmail]").setValue("123@qwe/ru");
        $("[id=submit]").click();

        $("[id=userEmail]").shouldHave(cssClass("field-error" ));
    }
}
