import com.google.gson.annotations.Expose;

public class Address {
    @Expose
    private String city;
    @Expose
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}