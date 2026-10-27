package tests;

import org.junit.jupiter.api.Test;
import pages.FullRegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;


public class FillsRequiredFields extends TestBase {

    FullRegistrationFormPage fullRegistrationFormPage = new FullRegistrationFormPage();
    @Test
    void fillsForm() {
        //заполнение обязательных полей формы

        fullRegistrationFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm();

        //проверка корректности заполнения

        fullRegistrationFormPage
                .modalContent()
                .checkCell("Student Name", firstName + " " + lastName)
                .checkCell("Gender", gender)
                .checkCell("Mobile", userNumber)
                .closeModal();


//        open("/automation-practice-form");
//
//        //заполнение обязательных полей формы
//
//        $("[id=firstName]").setValue(firstName);
//        $("[id=lastName]").setValue(lastName);
//        $("[id=genterWrapper]").$(byText(gender)).click();
//        $("[id=userNumber]").setValue(userNumber).click();
//        $("[id=submit]").click();
//
//        //проверка корректности заполнения
//
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
//        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
//        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
//
//        $("[id=closeLargeModal]").click();
    }
}
