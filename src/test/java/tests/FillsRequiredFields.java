package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillsRequiredFields extends TestBase {

    @Test
    void fillsForm() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber).click();
        $("[id=submit]").click();

        //проверка корректности заполнения

        $(".table-responsive").$(byText(studentName)).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText(studentGender)).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText(mobile)).parent().shouldHave(text(userNumber));

        $("[id=closeLargeModal]").click();
    }
}
