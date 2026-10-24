package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
   void successfulFillFormTest() {

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);

        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
   }

    @Test
    void successfulFormTest() {

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
    }

    @Test
    void successfulFormTest_chaining() {

        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail);
    }

}
