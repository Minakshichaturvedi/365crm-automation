package utils;

import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

public class ValidationUtils {
    
    public static boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public static boolean isPhoneValid(String phone) {
        String phoneRegex = "^[+]?[0-9]{10,15}$";
        return Pattern.compile(phoneRegex).matcher(phone.replaceAll("[\\s-()]", "")).matches();
    }

    public static boolean isUrlValid(String url) {
        String urlRegex = "^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})([/\\w .-]*)*/?$";
        return Pattern.compile(urlRegex).matcher(url).matches();
    }

    public static boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }
}