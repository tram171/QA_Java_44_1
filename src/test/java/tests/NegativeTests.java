package tests;

import org.junit.jupiter.api.Test;
import pages.FullRegistrationFormPage;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class NegativeTests extends TestBase {
    FullRegistrationFormPage fullRegistrationFormPage = new FullRegistrationFormPage();

    @Test
    // 1. Номер из 9 цифр
    void incorrectNumber() {
        //заполнение обязательных полей формы
        fullRegistrationFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(wrongUserNumber)
                .submitForm();

        //ожидаемый результат
        fullRegistrationFormPage
                .checkUserNumberBorderIsRed();
    }

    @Test
        // 2. Email не соответствует маске
    void incorrectEmail() {
            //заполнение обязательных полей формы

        fullRegistrationFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(wrongUserEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm();

        //ожидаемый результат
        fullRegistrationFormPage
                .checkUserEmailBorderIsRed();
    }

    @Test
        // 3. Пол не выбран
    void noGenderSelected() {
        //заполнение обязательных полей формы

        fullRegistrationFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)
                .submitForm();

        //ожидаемый результат
        fullRegistrationFormPage
                .checkGenderBorderIsRed("Male")
                .checkGenderBorderIsRed("Female")
                .checkGenderBorderIsRed("Other");

    }
}
