package my.education.webapplication.jdbc.hibernate;

import my.education.webapplication.jdbc.dao.hibernate.HibernateUserDaoImpl;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.jdbc.executor.TestData;
import my.education.webapplication.jdbc.l111.cache.CacheEngine;
import my.education.webapplication.jdbc.l111.cache.CacheEngineImpl;
import my.education.webapplication.jdbc.service.CacheService;
import org.junit.Test;

public class CacheServiceTest {
    private final CacheEngine<Long, UserDataSet> cache = new CacheEngineImpl<>(5, 20000, 0, false);
    private final CacheService cacheService = new CacheService(new HibernateUserDaoImpl(), cache);

    @Test
    public void cacheServiceSaveAndLoadTest() {
        for (int i = 1; i <= 5; i++)
            cacheService.save(TestData.userDataSet);
        for (long i = 1; i <= 5; i++)
            cacheService.loadById(i);

        System.out.println("Hits: " + cache.getHitCount());
        System.out.println("Losses: " + cache.getMissCount());
    }
}
