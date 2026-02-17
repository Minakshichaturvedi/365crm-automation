package utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomCompany() {
        return faker.company().name();
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getRandomWebsite() {
        return "www." + faker.company().name().toLowerCase().replaceAll("\\s+", "") + ".com";
    }

    public static String getRandomJobTitle() {
        return faker.job().title();
    }

    public static String getRandomMessage() {
        return faker.lorem().paragraph();
    }
}