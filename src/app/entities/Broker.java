package app.entities;

public class Broker {

    private final String name;
    private final String phone;
    private final String email;

    public Broker(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}