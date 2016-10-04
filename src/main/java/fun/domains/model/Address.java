package fun.domains.model;

/**
 * Created by imittal on 10/3/16.
 */
public class Address {

    private String houseNumber;
    private String city;

    public Address(String city, String houseNumber) {
        this.houseNumber = houseNumber;
        this.city = city;
    }

    public Address() {
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
