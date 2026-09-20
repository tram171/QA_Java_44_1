package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class negativeTests extends testBase {

    @Test
    // 1. Номер из 9 цифр
    void incorrectNumber() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы
        $("[id=firstName]").setValue("Тестовый");
        $("[id=lastName]").setValue("Тест");
        $("[id=gender-radio-1]").selectRadio("Male");
        $("[id=userNumber]").setValue("123456789").click();

        $("[id=submit]").click();

        //ожидаемый результат
        $("[id=userNumber]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
        // 2. Email не соответствует маске
    void incorrectEmail() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы
        $("[id=firstName]").setValue("Тестовый");
        $("[id=lastName]").setValue("Тест");
        $("[id=userEmail]").setValue("123@qwe.ru.");
        $("[id=gender-radio-1]").selectRadio("Male");
        $("[id=userNumber]").setValue("1234567890").click();

        $("[id=submit]").click();

        //ожидаемый результат
        $("[id=userEmail]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
        // 3. Пол не выбран
    void noGenderSelected() {
        open("/automation-practice-form");

        //заполнение обязательных полей формы
        $("[id=firstName]").setValue("Тестовый");
        $("[id=lastName]").setValue("Тест");
        $("[id=userNumber]").setValue("1234567890").click();

        $("[id=submit]").click();

        //ожидаемый результат
        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-2]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-3]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
