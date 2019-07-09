package PageObjects;

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;

    public User(String address, String phone, String name, int id, String email, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
