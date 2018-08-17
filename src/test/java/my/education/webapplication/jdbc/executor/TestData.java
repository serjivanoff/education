package my.education.webapplication.jdbc.executor;

import my.education.webapplication.jdbc.dataset.AddressDataSet;
import my.education.webapplication.jdbc.dataset.PhoneDataSet;
import my.education.webapplication.jdbc.dataset.UserDataSet;

import java.util.Arrays;

public class TestData {
    public static final UserDataSet USER_DATA_SET = new UserDataSet("Name", 99, null, null);

    public static UserDataSet userDataSet = new UserDataSet("Name", 99,
            new AddressDataSet("Sadovaja"),
            Arrays.asList(new PhoneDataSet("0666688826"), new PhoneDataSet("0506110541")));

    static {
        userDataSet.getPhones().forEach(p -> p.setUser(userDataSet));
    }
}
