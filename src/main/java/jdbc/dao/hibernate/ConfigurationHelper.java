package jdbc.dao.hibernate;

import jdbc.dataset.AddressDataSet;
import jdbc.dataset.PhoneDataSet;
import jdbc.dataset.UserDataSet;
import org.hibernate.cfg.Configuration;

/**
 * Created by bender on 11.08.2018.
 */
public class ConfigurationHelper {

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/otus?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "bender");
        configuration.setProperty("hibernate.connection.password", "bender");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.addAnnotatedClass(AddressDataSet.class);
        configuration.addAnnotatedClass(PhoneDataSet.class);
        configuration.addAnnotatedClass(UserDataSet.class);
        return configuration;
    }

}
