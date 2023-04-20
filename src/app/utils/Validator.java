package app.utils;

public class Validator {

    public static boolean isDataValid(int quota, double price) {
        return quota > 0 && price > 0; // заменено & на &&
    }

    public static boolean isDataVal(int productQuota, double productPrice) {
        return productQuota > 0 && productPrice > 0;
    }
}
