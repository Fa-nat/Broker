package app.views;

import app.entities.Broker;
import app.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class AppView {

    private final Scanner scanner = new Scanner(System.in);

    public Broker getBrokerData() {
        System.out.print("Enter broker name: ");
        String name = scanner.nextLine();
        System.out.print("Enter broker phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter broker email: ");
        String email = scanner.nextLine();
        return new Broker(name, phone, email);
    }

    public Product getProductData() {
        scanner.useLocale(Locale.ENGLISH);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quota, pcs.: ");
        int quota = scanner.nextInt();
        System.out.print("Enter product price, USD: ");
        double price = scanner.nextDouble();
        return new Product(name, quota, price);
    }

    public void closeScanner() {
        scanner.close();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
