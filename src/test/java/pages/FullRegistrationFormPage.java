package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FullRegistrationFormPage {

    // Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTable = new ResultTableComponent();
    private SelenideElement subjectInput = $("#subjectsInput");
    private SelenideElement hobbyInput = $("#hobbiesWrapper");
    private SelenideElement userPicture = $("#uploadPicture");
    private SelenideElement userCurrentAddressInput = $("#currentAddress");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");

    private SelenideElement submitButton = $("#submit");
    private SelenideElement closeModalButton = $("#closeLargeModal");
    private SelenideElement modalContentCheck = $(".modal-content");




    // Actions
    public FullRegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    };

    public FullRegistrationFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    };

    public FullRegistrationFormPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    };

    public FullRegistrationFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    };

    public FullRegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    };

    public FullRegistrationFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    };

    public FullRegistrationFormPage setDateOfBirth(String year, String month, String day) {
        $("[id=dateOfBirthInput]").click();
        calendar.setDate(year, month, day);
        return this;
    };

    public FullRegistrationFormPage selectSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    };

    public FullRegistrationFormPage selectHobbies(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    };

    public FullRegistrationFormPage uploadPicture(String value) {
        userPicture.uploadFromClasspath(value);
        return this;
    };

    public FullRegistrationFormPage typeCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    };

    public FullRegistrationFormPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    };

    public FullRegistrationFormPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    };

    public FullRegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    };

    public FullRegistrationFormPage modalContent() {
        modalContentCheck.shouldBe(visible);
        return this;
    }

    public FullRegistrationFormPage checkCell(String key, String value) {
        resultTable.checkCell(key, value);
        return this;
    }

    public FullRegistrationFormPage closeModal() {
        closeModalButton.click();
        return this;
    }
    public FullRegistrationFormPage checkUserNumberBorderIsRed() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public FullRegistrationFormPage checkUserEmailBorderIsRed() {
        userEmailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public FullRegistrationFormPage checkGenderBorderIsRed(String genderValue) {
        genderInput.$(byText(genderValue))
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }


}