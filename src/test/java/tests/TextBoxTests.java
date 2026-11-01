package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

import static tests.testdata.TestData.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
   void successfulFillFormTest() {

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);

        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
   }

    @Test
    void successfulFormTest() {

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
    }


    @Test
    void successfulFormTest_chaining() {

        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void successfulFillFormTestWithFaker() {

        Faker faker = new Faker();
        Faker fakerRu = new Faker(new Locale("ru"));

        String userName = fakerRu.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = fakerRu.address().fullAddress();
        String permanentAddress = fakerRu.address().fullAddress();

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);

        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
    }

    @Test
    void successfulFillFormTestWithRandomUtils() {

        String
            userName = getRandomString(10),
            userEmail = getRandomEmail(),
            currentAddress =  getRandomString(100),
            permanentAddress =  getRandomString(90);

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);

        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
    }


    String
            userNameU,
            userEmailU,
            currentAddressU,
            permanentAddressU;

    @BeforeEach
    void prepareRandomData() {
        userNameU = getRandomString(10);
        userEmailU = getRandomEmail();
        currentAddressU = getRandomString(100);
        permanentAddressU = getRandomString(90);
    }

    @Test
    void successfulFillFormTestWithRandomUtilsWithBeforeEach() {

//        String
//                userName = getRandomString(10),
//                userEmail = getRandomEmail(),
//                currentAddress =  getRandomString(100),
//                permanentAddress =  getRandomString(90);

        textBoxPage.openPage();
        textBoxPage.typeUserName(userNameU);
        textBoxPage.typeUserEmail(userEmailU);

        textBoxPage.typeCurrentAddress(currentAddressU);
        textBoxPage.typePermanentAddress(permanentAddressU);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userNameU);
        textBoxPage.checkField("email", userEmailU);
        textBoxPage.checkField("currentAddress", currentAddressU);
        textBoxPage.checkField("permanentAddress", permanentAddressU);
    }
}
