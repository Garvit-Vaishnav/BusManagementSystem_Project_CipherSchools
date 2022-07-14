package bus_managment_system;

public class User {
    private Address address;
    private Contact contact;
    private String password;

    public User(){

    }

    public User(Address address, Contact contact, String password) {
        this.address = address;
        this.contact = contact;
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", contact=" + contact +
                ", password='" + password + '\'' +
                '}';
    }
}
