import com.google.gson.annotations.Expose;

import java.util.List;

public class User {
    @Expose
    private String login;

    private String password;

    @Expose
    private Address address;

    @Expose
    private List<String> hobbies;

    public User(String login, String password, Address address, List<String> hobbies) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.hobbies = hobbies;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}