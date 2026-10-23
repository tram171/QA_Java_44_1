package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class NegativeTests extends TestBase {

    @Test
    // 1. Номер из 9 цифр
    void incorrectNumber() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber).click();

        $("[id=submit]").click();

        //ожидаемый результат
        $("[id=userNumber]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
        // 2. Email не соответствует маске
    void incorrectEmail() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber).click();

        $("[id=submit]").click();

        //ожидаемый результат
        $("[id=userEmail]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
        // 3. Пол не выбран
    void noGenderSelected() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userNumber]").setValue(userNumber).click();

        $("[id=submit]").click();

        //ожидаемый результат
        $("[id=genterWrapper]").$(byText("Male")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=genterWrapper]").$(byText("Female")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=genterWrapper]").$(byText("Other")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
