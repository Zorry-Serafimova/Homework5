package PageObjects;

public class User {

    private int id;
    private String name;
    private String userName;
    private String email;
    private String address;
    private String phone;

    public User(int id, String name, String userName, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
