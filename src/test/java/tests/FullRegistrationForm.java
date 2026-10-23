package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;


public class FullRegistrationForm extends TestBase {

    @Test
    void fillsFullForm() {
        open("/automation-practice-form");

        //заполнение всех полей формы

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__day--" + birthDay).click();
        $("[id=subjectsInput]").setValue(subjectFirst).pressEnter();
        $("[id=subjectsInput]").setValue(subjectsSecond).pressEnter();
        $("[id=hobbiesWrapper]").$(byText(hobbyFirst)).click();
        $("[id=hobbiesWrapper]").$(byText(hobbySecond)).click();
        $("[id=hobbiesWrapper]").$(byText(hobbyThird)).click();
        $("[id=uploadPicture]").uploadFromClasspath(picture);
        $("[id=currentAddress]").setValue(currentAddress).pressEnter();
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=react-select-4-input]").setValue(city).pressEnter();

        $("[id=submit]").click();

        //проверка корректности заполнения

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthDay.replaceFirst("^0", "") + " " + birthMonth + "," + birthYear));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectFirst + ", " + subjectsSecond));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbyFirst + ", " + hobbySecond + ", " + hobbyThird));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(picture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));

        $("[id=closeLargeModal]").click();


    }
}
