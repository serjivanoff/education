package my.education.webapplication.jdbc.service;

import com.google.gson.Gson;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.messages.Message;
import my.education.webapplication.messages.MessageSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bender on 26.08.2018.
 */
@Service
public class FrontServiceImpl implements FrontService {
    private Map<String, UserDataSet> users = new HashMap<>();
    @Autowired
    private MessageSystem ms;

    @PreDestroy
    private void dispose(){
        ms.dispose();
    }
    @Override
    public void handle(Message message) {
        ms.getMessages().add(message);
        ms.start();
    }

    @Override
    public void addUser(String user) {
        UserDataSet userDataSet = new Gson().fromJson(user, UserDataSet.class);
        users.put(userDataSet.getName(), userDataSet);
    }

    @Override
    public UserDataSet getUser(String name) {
        return users.get(name);
    }
}