package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class fullRegistrationForm extends testBase {

    @Test
    void fillsFullForm() {
        open("/automation-practice-form");

        //заполнение всех полей формы

        $("[id=firstName]").setValue("David");
        $("[id=lastName]").setValue("Lynch");
        $("[id=userEmail]").setValue("lynch@qwe.ru");
        $("[id=gender-radio-3]").selectRadio("Other");
        $("[id=userNumber]").setValue("1234567890");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--003").click();
        $("[id=subjectsInput]").setValue("Arts").pressEnter();
        $("[id=subjectsInput]").setValue("Biology").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=hobbies-checkbox-2]").click();
        $("[id=hobbies-checkbox-3]").click();
        $("[id=uploadPicture]").uploadFromClasspath("cat.jpg");
        $("[id=currentAddress]").setValue("г. Новосибирск, ул. Красноводская, д. 36").pressEnter();
        $("[id=react-select-3-input]").setValue("Rajasthan").pressEnter();
        $("[id=react-select-4-input]").setValue("Jaipur").pressEnter();
        $("[id=submit]").click();

        //проверка корректности заполнения

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("David Lynch"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("lynch@qwe.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("03 March,1993"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts, Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("cat.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("г. Новосибирск, ул. Красноводская, д. 36"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));

        $("[id=closeLargeModal]").click();


    }
}
