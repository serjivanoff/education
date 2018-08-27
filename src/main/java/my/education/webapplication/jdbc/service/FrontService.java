package my.education.webapplication.jdbc.service;

import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.messages.Message;

/**
 * Created by bender on 26.08.2018.
 */
public interface FrontService {
    void handle(Message message);
    void addUser(String user);
    UserDataSet getUser(String name);
}
