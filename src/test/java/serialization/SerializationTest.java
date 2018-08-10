package serialization;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import serialization.model.Address;
import serialization.model.Room;
import serialization.model.SimplestUser;
import serialization.model.User;
import serialization.util.TestUtils;

import java.util.Arrays;
import java.util.List;

public class SerializationTest {
    private Gson gson = new Gson();
    private JsonSerializer jsonSerializer = new JsonSerializer();

    @Test
    public void simpleSerializeTest() throws IllegalAccessException {
        SimplestUser expected = new SimplestUser("theName", 55, 55);
        String jsonExpected = gson.toJson(expected), jsonActual = new JsonSerializer().toJson(expected);
        System.out.println(jsonExpected);
        System.out.println();
        System.out.println(jsonActual);
        SimplestUser actual = gson.fromJson(jsonActual, SimplestUser.class);
        Assert.assertTrue(TestUtils.simpleObjectMatcher(actual, expected));
    }

    @Test
    public void objectWithReferencesSerializationTest() throws IllegalAccessException {
        Address address = new Address(86114, "Makedonia", "Sadovaja", 11);
        User expected = new User("Vasja", 22, 40, address);
        String json = jsonSerializer.toJson(expected);
        User actual = gson.fromJson(json, User.class);
        Assert.assertTrue(TestUtils.simpleObjectMatcher(actual, expected));
    }

    @Test
    public void objectWithArraysAnnCollectionSerializationTest() throws IllegalAccessException {
        Address address = new Address(86114, "Makedonia", "Sadovaja", 11);
        List<User> users = Arrays.asList(new User("Vasja", 12, 33, address), new User ("Petja", 33, 44, address));
        int[] indexes = new int[]{4,5,6};
        Room expected = new Room(indexes, users, 4, new Address(86114, "Makedonia", "Sadovaja", 11));
        String json = jsonSerializer.toJson(expected);
        Room actual = gson.fromJson(json, Room.class);
        Assert.assertTrue(TestUtils.simpleObjectMatcher(actual, expected));
    }

    @Test
    public void myUtilTest() {
    }
}
