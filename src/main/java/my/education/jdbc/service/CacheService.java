package my.education.jdbc.service;

import my.education.jdbc.dao.UserDAO;
import my.education.jdbc.dataset.UserDataSet;
import my.education.jdbc.l111.cache.CacheEngine;
import my.education.jdbc.l111.cache.CacheEngineImpl;
import my.education.jdbc.l111.cache.MyElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService implements DBService {
    private final UserDAO userDAO;
    private final CacheEngine<Long, UserDataSet> cacheEngine;

    public CacheService(UserDAO userDAO, CacheEngine<Long, UserDataSet> cacheEngine) {
        this.userDAO = userDAO;
        this.cacheEngine = cacheEngine;
    }

    @Autowired
    public CacheService(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.cacheEngine = new CacheEngineImpl<>(5, 5000, 0, false);
    }

    @Override
    public void save(UserDataSet user) {
        userDAO.save(user);
        cacheEngine.put(new MyElement<>(user.getId(), user));
    }

    @Override
    public UserDataSet loadById(long id) {
        MyElement<Long, UserDataSet> element = cacheEngine.get(id);
        return element==null? userDAO.load(id) : element.getValue();
    }

    @Override
    public String toString() {
        return "CacheService{" +
                "userDAO=" + userDAO +
                ", cacheEngine=" + cacheEngine +
                '}';
    }

    public CacheEngine<Long, UserDataSet> getCacheEngine() {
        return cacheEngine;
    }
}
