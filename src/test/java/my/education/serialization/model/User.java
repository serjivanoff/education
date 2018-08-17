package my.education.serialization.model;

public class User extends SimplestUser {
    private Address address;

    public User(String name, int age, int weight, Address address) {
        super(name, age, weight);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return !(getName() == null && user.getName() != null)
                && getAge() == user.getAge()
                && getWeight() == user.getWeight()
                && getName().equals(user.getName())
                && address.equals(user.address);
    }

}
