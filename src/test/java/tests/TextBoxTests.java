package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
   void successfulFillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("David Lynch");
        $("[id=userEmail]").setValue("lynch@qwe.ru");
        $("[id=currentAddress]").setValue("his first address 1");
        $("[id=permanentAddress]").setValue("his second address 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("David Lynch"));
        $("[id=output] [id=email]").shouldHave(text("lynch@qwe.ru"));
        $("[id=output] [id=currentAddress]").shouldHave(text("his first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("his second address 2"));



   }

}
