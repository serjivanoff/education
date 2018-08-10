package serialization.model;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by bender on 06.08.2018.
 */
public class Room {
    private int[] indexes;
    private Collection<User> users;
    private int number;
    private Address address;

    public Room(int[] indexes, Collection<User> users, int number, Address address) {
        this.indexes = indexes;
        this.users = users;
        this.number = number;
        this.address = address;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int[] getIndexes() {
        return indexes;
    }
    public void setIndexes(int[] indexes) {
        this.indexes = indexes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (number != room.number) return false;
        if (!Arrays.equals(indexes, room.indexes)) return false;
        if (users != null ? !users.equals(room.users) : room.users != null) return false;
        return address != null ? address.equals(room.address) : room.address == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(indexes);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
