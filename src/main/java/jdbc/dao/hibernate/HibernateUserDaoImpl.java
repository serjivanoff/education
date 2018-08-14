package jdbc.dao.hibernate;

import jdbc.dao.UserDAO;
import jdbc.dataset.UserDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by bender on 11.08.2018.
 */
public class HibernateUserDaoImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    public HibernateUserDaoImpl() {
        this.sessionFactory = createSessionFactory(ConfigurationHelper.getConfiguration());

    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public void save(UserDataSet user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        long id = ((long) session.save(user));
        System.out.println(id);
//        user.getPhones().forEach(session::save);
        session.flush();
        transaction.commit();
        session.close();
    }

    @Override
    public UserDataSet load(long id) {
        Session session = sessionFactory.openSession();
        UserDataSet user = session.get(UserDataSet.class, id);
        session.close();
        return user;
    }
}
