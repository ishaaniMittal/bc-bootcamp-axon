package fun.domains.model;

/**
 * Created by imittal on 10/3/16.
 */
public class Applicant {

    private String name;
    private Address address;

    public Applicant(String name, Address address) {
        this.name = name;
        this.address = new Address(address.getCity(), address.getHouseNumber());
    }

    public Applicant() {
    }

    public String getName() {
        return name;
    }


    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Applicant applicant = (Applicant) o;

        if (!name.equals(applicant.name)) return false;
        return address.equals(applicant.address);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
