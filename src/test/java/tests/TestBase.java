package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static String firstName = "David";
    public static String lastName = "Lynch";
    public static String userEmail = "lynch@qwe.ru";
    public static String gender = "Other";
    public static String userNumber = "1234567890";
    public static String birthYear = "1993";
    public static String birthMonth = "March";
    public static String birthDay = "003";
    public static String subjectFirst = "Arts";
    public static String subjectsSecond = "Biology";
    public static String hobbyFirst = "Sports";
    public static String hobbySecond = "Reading";
    public static String hobbyThird = "Music";
    public static String picture = "cat.jpg";
    public static String currentAddress = "г. Новосибирск, ул. Красноводская, д. 36";
    public static String state = "Rajasthan";
    public static String city = "Jaipur";


    public static String studentName = "Student Name";
    public static String studentEmail = "Student Email";
    public static String studentGender= "Gender";
    public static String mobile = "Mobile";
    public static String dateOfBirth = "Date of Birth";
    public static String subjects = "Subjects";
    public static String hobbies = "Hobbies";
    public static String studentsPicture = "Picture";
    public static String address = "Address";
    public static String stateAndCity = "State and City";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";

    }
    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
