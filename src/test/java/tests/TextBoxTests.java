package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase {

//    String userName;
//    String userEmail;
//    String currentAddress;
//    String permanentAddress;
//
//    @BeforeEach
//    public void setUp() {
//        userName = "David Lynch";
//        userEmail = "lynch@qwe.ru";
//        currentAddress =  "his first address 1";
//        permanentAddress =  "his second address 2";
//    }

    @Test
   void successfulFillFormTest() {
//        String userName = "David Lynch";
//        String userEmail = "lynch@qwe.ru";
//        String currentAddress =  "his first address 1";
//        String permanentAddress =  "his second address 2";

        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmail));
        $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
   }

    @Test
    void successfulFormTest() {
//        String userName = "David Lynch";
//        String userEmail = "lynch@qwe.ru";

        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmail));

    }

}
