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

        $("[id=firstName]").setValue("Петров-Водкин");
        $("[id=lastName]").setValue("Арсений");
        $("[id=genterWrapper]").$(byText("Other")).click();
        $("[id=userNumber]").setValue("1234567890").click();
        $("[id=submit]").click();

        //проверка корректности заполнения

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Петров-Водкин Арсений"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));

        $("[id=closeLargeModal]").click();
    }
}
