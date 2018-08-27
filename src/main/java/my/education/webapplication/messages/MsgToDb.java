package my.education.webapplication.messages;

import com.google.gson.Gson;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.jdbc.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bender on 26.08.2018.
 */
@Component
public class MsgToDb extends Message {
    private DBService dbService;
    private  MessageSystem ms;
    private final Gson gson = new Gson();
    @Autowired
    public MsgToDb(DBService dbService, MessageSystem ms){
        this.dbService = dbService;
        this.ms = ms;
    }
    public MsgToDb(String from, String to, String payload) {
        super(from, to, payload);
    }

    @Override
    public void exec(String to) {
        UserDataSet user = dbService.loadById(Long.parseLong(getPayload()));
        ms.getMessages().add(new MsgToFront("db", "front", gson.toJson(user)));
    }
}
