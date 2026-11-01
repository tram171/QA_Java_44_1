package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FullRegistrationFormPage;
import static tests.testdata.TestData.*;
import static utils.RandomUtils.*;


public class FullRegistrationForm extends TestBase {
    FullRegistrationFormPage fullRegistrationFormPage = new FullRegistrationFormPage();

    String
            firstNameUtils,
            lastNameUtils,
            userEmailUtils,
            genderUtils,
            userNumberUtils,
            birthYearUtils,
            birthMonthUtils,
            birthDayUtils,
            subjectUtils,
            hobbyUtils,
            currentAddressUtils,
            stateUtils,
            cityUtils;

    @BeforeEach
        void prepareRandomData() {
        firstNameUtils = getRandomString(10);
        lastNameUtils = getRandomString(8);
                userEmailUtils = getRandomEmail();
                genderUtils = getRandomGender();
                userNumberUtils = getRandomPhone();
                birthYearUtils = getRandomBirthYear();
                birthMonthUtils = getRandomBirthMonth();
                birthDayUtils = getRandomBirthDay();
                subjectUtils = getRandomSubject();
                hobbyUtils = getRandomHobby();
                currentAddressUtils = getRandomString(99);
                stateUtils = getRandomState();
                cityUtils = getRandomCity(stateUtils);
    }

    @Test
    void fillsFullFormNew() {

        //заполнение всех полей формы

        fullRegistrationFormPage
                .openPage()
                .typeFirstName(firstNameUtils)
                .typeLastName(lastNameUtils)
                .typeUserEmail(userEmailUtils)
                .setGender(genderUtils)
                .typeUserNumber(userNumberUtils)
                .setDateOfBirth(birthYearUtils, birthMonthUtils, birthDayUtils)
                .selectSubject(subjectUtils)
                .selectHobbies(hobbyUtils)
                .uploadPicture(picture)
                .typeCurrentAddress(currentAddressUtils)
                .setState(stateUtils)
                .setCity(cityUtils)
                .submitForm();


        //проверка корректности заполнения

        fullRegistrationFormPage
                .modalContent()
                .checkCell("Student Name", firstNameUtils + " " + lastNameUtils)
                .checkCell("Student Email", userEmailUtils)
                .checkCell("Gender", genderUtils)
                .checkCell("Mobile", userNumberUtils)
                .checkCell("Date of Birth", birthDayUtils.replaceFirst("^0", "") + " " + birthMonthUtils + "," + birthYearUtils)
                .checkCell("Subjects", subjectUtils)
                .checkCell("Hobbies", hobbyUtils)
                .checkCell("Picture", picture)
                .checkCell("Address", currentAddressUtils)
                .checkCell("State and City", stateUtils + " " + cityUtils)
                .closeModal();

    }


//    FullRegistrationFormPage fullRegistrationFormPage = new FullRegistrationFormPage();
//    @Test
//    void fillsFullFormNew() {
//
//        //заполнение всех полей формы
//
//        fullRegistrationFormPage
//                .openPage()
//                .typeFirstName(firstName)
//                .typeLastName(lastName)
//                .typeUserEmail(userEmail)
//                .setGender(gender)
//                .typeUserNumber(userNumber)
//                .setDateOfBirth(birthYear, birthMonth, birthDay)
//                .selectSubject(subjectFirst)
//                .selectSubject(subjectsSecond)
//                .selectHobbies(hobbyFirst)
//                .selectHobbies(hobbySecond)
//                .selectHobbies(hobbyThird)
//                .uploadPicture(picture)
//                .typeCurrentAddress(currentAddress)
//                .setState(state)
//                .setCity(city)
//                .submitForm();
//
//
//        //проверка корректности заполнения
//
//        fullRegistrationFormPage
//                .modalContent()
//                .checkCell("Student Name", firstName + " " + lastName)
//                .checkCell("Student Email", userEmail)
//                .checkCell("Gender", gender)
//                .checkCell("Mobile", userNumber)
//                .checkCell("Date of Birth", birthDay.replaceFirst("^0", "") + " " + birthMonth + "," + birthYear)
//                .checkCell("Subjects", subjectFirst + ", " + subjectsSecond)
//                .checkCell("Hobbies", hobbyFirst + ", " + hobbySecond + ", " + hobbyThird)
//                .checkCell("Picture", picture)
//                .checkCell("Address", currentAddress)
//                .checkCell("State and City", state + " " + city)
//                .closeModal();
//
//    }

//    @Test
//    void fillsFullFormOld() {
//        open("/automation-practice-form");
//
//        //заполнение всех полей формы
//
//        $("[id=firstName]").setValue(firstName);
//        $("[id=lastName]").setValue(lastName);
//        $("[id=userEmail]").setValue(userEmail);
//        $("[id=genterWrapper]").$(byText(gender)).click();
//        $("[id=userNumber]").setValue(userNumber);
//        $("[id=dateOfBirthInput]").click();
//        $(".react-datepicker__year-select").selectOption(birthYear);
//        $(".react-datepicker__month-select").selectOption(birthMonth);
//        $(".react-datepicker__day--" + birthDay).click();
//        $("[id=subjectsInput]").setValue(subjectFirst).pressEnter();
//        $("[id=subjectsInput]").setValue(subjectsSecond).pressEnter();
//        $("[id=hobbiesWrapper]").$(byText(hobbyFirst)).click();
//        $("[id=hobbiesWrapper]").$(byText(hobbySecond)).click();
//        $("[id=hobbiesWrapper]").$(byText(hobbyThird)).click();
//        $("[id=uploadPicture]").uploadFromClasspath(picture);
//        $("[id=currentAddress]").setValue(currentAddress).pressEnter();
//        $("[id = state]").click();
//        $("[id=stateCity-wrapper]").$(byText(state)).click();
//        $("[id = city]").click();
//        $("[id=stateCity-wrapper]").$(byText(city)).click();
//
//        $("[id=submit]").click();
//
//        //проверка корректности заполнения
//
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
//        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
//        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
//        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
//        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthDay.replaceFirst("^0", "") + " " + birthMonth + "," + birthYear));
//        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectFirst + ", " + subjectsSecond));
//        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbyFirst + ", " + hobbySecond + ", " + hobbyThird));
//        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(picture));
//        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
//        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
//
//        $("[id=closeLargeModal]").click();
//
//    }
}
