package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(000000000, 888888888));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomHobby());
        System.out.println(getRandomState());
        System.out.println(getRandomCity(getRandomState()));
        System.out.println(getRandomSubject());
        System.out.println(getRandomBirthDay());
        System.out.println(getRandomBirthMonth());
        System.out.println(getRandomBirthYear());




    }

    public static String getRandomEmail() {
//        return result.toString();
//        return getRandomString(9) + "@" + getRandomString(5) + ".com";
        return  format( "%s@%s.com", getRandomString(5), getRandomString(5));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        String phoneTemplate = "8%s%s%s%s";
        return format(phoneTemplate, getRandomInt(1,9), getRandomInt(111,999),getRandomInt(111,999),getRandomInt(11,99),getRandomInt(11,99));
    }

    public static String getRandomGenderBadPractice() {
        String[] genders = {"Male", "Female", "Other"};

        int randomIndex = getRandomInt(0, 2);
        return genders[randomIndex];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromStringArray(genders);
//        int randomIndex = getRandomInt(0, 2);
//        return genders[randomIndex];
    }

    public static String getRandomItemFromStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);
        return stringArray[randomIndex];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromStringArray(hobbies);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Physics", "Chemistry", "Computer Science", "English", "Economics", "Commerce", "Social Studies"};
        return getRandomItemFromStringArray(subjects);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromStringArray(states);
    }

    public static String getRandomCity(String state) {
        String[] cities;
                switch (state) {
                    case "NCR":
                        cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                        break;
                    case "Uttar Pradesh":
                        cities = new String[]{"Agra", "Lucknow", "Merrut"};
                        break;
                    case "Haryana":
                        cities = new String[]{"Karnal", "Panipat"};
                        break;
                    case "Rajasthan":
                        cities = new String[]{"Jaipur", "Jaiselmer"};
                        break;
                    default:
                        throw new IllegalArgumentException("Неизвестный штат: " + state);
                }
        return getRandomItemFromStringArray(cities);
    }

    public static String getRandomBirthYear() {

        return String.valueOf(getRandomInt(1900, 2100));
    }

    public static String getRandomBirthMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return getRandomItemFromStringArray(months);
    }

    public static String getRandomBirthDay() {
        int day = getRandomInt(1, 28);
        return String.format("%03d", day);
    }

    public static String getRandomString(int length) {
                String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                StringBuilder result = new StringBuilder();
                SecureRandom rnd = new SecureRandom();
                for (int i = 0; i < length; i++)
                    result.append(SYMBOLS.charAt(rnd.nextInt(SYMBOLS.length())));
                return result.toString();
    }

    }
